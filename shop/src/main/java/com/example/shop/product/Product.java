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

    @Column(name = "product_name", length=50)
    private String name;
    @Column(name = "product_price",precision=10,scale = 0)
    private Integer price;
    @Column(name = "product_amount",precision = 7,scale = 0)
    private Integer amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void updateInfo(String name, Integer price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount=amount;
    }
}