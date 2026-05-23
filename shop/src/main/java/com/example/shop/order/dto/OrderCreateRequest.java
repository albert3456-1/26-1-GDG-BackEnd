package com.example.shop.order.dto;

import com.example.shop.common.message.ErrorMessage;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class OrderCreateRequest {

    @NotNull(message= ErrorMessage.ORDER_ID_NOT_NULL)
    @Size(min=4,max=50,message = ErrorMessage.ORDER_ID_SIZE)
    private String orderId;


    //private String status;

    @NotNull(message= ErrorMessage.TOTAL_PRICE_NOT_NULL)
    @Min(value = 0, message = ErrorMessage.TOTAL_PRICE_TOO_LOW)
    @Max(value = 99999999, message = ErrorMessage.TOTAL_PRICE_TOO_HIGH)
    private Integer totalPrice;

    @NotNull(message= ErrorMessage.POINT_USED_NOT_NULL)
    @Min(value = 0, message = ErrorMessage.POINT_USED_TOO_LOW)
    private Integer pointUsed;

    @NotNull(message= ErrorMessage.CASH_AMOUNT_NOT_NULL)
    @Min(value = 0, message = ErrorMessage.CASH_AMOUNT_TOO_LOW)
    private Integer cashAmount;

    public OrderCreateRequest(String orderId, int totalPrice,int pointUsed,int cashAmount){
        this.orderId=orderId;
        //this.status=status;
        this.totalPrice=totalPrice;
        this.pointUsed=pointUsed;
        this.cashAmount=cashAmount;
    }
}
