package com.example.shop.product;

import com.example.shop.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private int price;
    @Column(name = "product_amount")
    private int amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void updateInfo(String name, int price, int amount) {
        if (name != null) {
            this.name = name;
        }
        /*if(price != null) {
            this.price = price;
        }
        if(amount != null){
            this.amount=amount;
        }*/
    }
}