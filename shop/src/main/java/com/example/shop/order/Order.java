package com.example.shop.order;

import com.example.shop.member.Member;
import com.example.shop.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@NoArgsConstructor
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="order_date")
    private LocalDateTime orderDate;
    @Column(name="total_price", precision = 10, scale = 0)
    private int totalPrice;
    @Column(name="point_used",scale = 0)
    private int pointused;
    @Column(name="cash_amount",scale = 0)
    private int cashAmount;
    @Column(name="status")
    private String status;
    @Column(name="order_code", length = 50)
    private String orderId;

    public Order(String orderId, int totalPrice, int pointused,int cashAmount){
        this.orderId=orderId;
        this.totalPrice=totalPrice;
        this.pointused=pointused;
        this.cashAmount=cashAmount;
        this.status="주문 확인중";
    }

}
