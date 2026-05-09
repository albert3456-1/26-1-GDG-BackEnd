package com.example.shop.order.dto;

import lombok.Getter;

@Getter
public class OrderCreateRequest {
    private String orderId;
    private String status;
    private int total_price;
    private int point_used;
    private int cash_amount;

    public OrderCreateRequest(String orderId, String status, int total_price,int point_used,int cash_amount){
        this.orderId=orderId;
        this.status=status;
        this.total_price=total_price;
        this.point_used=point_used;
        this.cash_amount=cash_amount;
    }
}
