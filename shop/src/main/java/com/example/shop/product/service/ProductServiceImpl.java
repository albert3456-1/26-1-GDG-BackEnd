package com.example.shop.product.service;

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
            throw new RuntimeException("이미 존재하는 로그인 상품입니다: "+request.getName());
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
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        return product;
    }
    @Override
    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest request){
        Product product=productRepository.findById(id);
        if (product==null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        product.updateInfo(request.getName(),request.getPrice(),request.getAmount());
    }
    @Override
    @Transactional
    public void deleteProduct(Long id){
        Product product=productRepository.findById(id);
        if (product==null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        productRepository.deleteById(id);
    }
}
