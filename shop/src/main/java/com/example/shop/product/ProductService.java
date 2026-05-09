package com.example.shop.product;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //@Transtional
    public long createProduct(ProductCreateRequest request){
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
    //@Transtional(readOnly=True)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    //@Transtional(readOnly=True)
    public Product getProductById(Long id) {
        Product product =productRepository.findById(id);
        if (product==null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        return product;
    }
    //@Transtional
    public void updateProduct(Long id, ProductUpdateRequest request){
        Product product=productRepository.findById(id);
        if (product==null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        product.updateInfo(request.getName(),request.getPrice(),request.getAmount());
    }
    //@Transtional
    public void deleteProduct(Long id){
        Product product=productRepository.findById(id);
        if (product==null){
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        productRepository.deleteById(id);
    }
}
