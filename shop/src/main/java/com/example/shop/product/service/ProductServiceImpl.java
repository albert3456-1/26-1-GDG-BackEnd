package com.example.shop.product.service;

import com.example.shop.common.exception.BadRequestException;
import com.example.shop.common.exception.NotFoundException;
import com.example.shop.common.message.ErrorMessage;
import com.example.shop.product.Product;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import com.example.shop.product.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final JpaProductRepository productRepository;

    @Override
    @Transactional
    public Long createProduct(ProductCreateRequest request){
        Product existingProduct=productRepository.findByName(request.getName());
        if( existingProduct!=null){
            throw new BadRequestException(ErrorMessage.PRODUCT_ALREADY_EXISTS +request.getName());
        }
        Product product=new Product(
                request.getName(),
                request.getPrice(),
                request.getAmount()
        );
        productRepository.save(product);

        return product.getId();
    }
    @Override
    @Transactional(readOnly=true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Transactional(readOnly=true)
    public Product getProductById(Long id) {
        Product product =productRepository.findById(id);
        if (product==null){
            throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND);
        }
        return product;
    }
    @Override
    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest request){
        Product product=productRepository.findById(id);
        if (product==null){
            throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND);
        }

        String name= request.getName() != null ? request.getName(): product.getName();;
        Integer price= request.getPrice() != null ? request.getPrice():product.getPrice();
        Integer amount= request.getAmount() != null ? request.getAmount(): product.getAmount();


        product.updateInfo(name,price,amount);
    }
    @Override
    @Transactional
    public void deleteProduct(Long id){
        Product product=productRepository.findById(id);
        if (product==null){
            throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(id);
    }
}
