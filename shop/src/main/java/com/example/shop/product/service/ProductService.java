package com.example.shop.product.service;

import com.example.shop.product.Product;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
    Long createProduct(ProductCreateRequest productCreateRequest);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void updateProduct(Long id, ProductUpdateRequest productUpdateRequest);
    void deleteProduct(Long id);
}
