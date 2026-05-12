package com.example.shop.order.dto;

import lombok.Getter;

@Getter
public class OrderCreateRequest {
    private String orderId;
    private String status;
    private int totalPrice;
    private int pointUsed;
    private int cashAmount;

    public OrderCreateRequest(String orderId, String status, int totalPrice,int pointUsed,int cashAmount){
        this.orderId=orderId;
        this.status=status;
        this.totalPrice=totalPrice;
        this.pointUsed=pointUsed;
        this.cashAmount=cashAmount;
    }
}
