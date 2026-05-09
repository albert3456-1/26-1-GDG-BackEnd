package com.example.shop.product.dto;

import com.example.shop.product.Product;
import lombok.Getter;

@Getter
public class ProductCreateRequest {
    private String name;
    private int price;
    private int amount;

    public ProductCreateRequest(String name, int price, int amount){
        this.name=name;
        this.price=price;
        this.amount=amount;
    }
}
