package com.example.shop.product.dto;

import com.example.shop.common.message.ErrorMessage;
import com.example.shop.product.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProductCreateRequest {

    @NotNull(message= ErrorMessage.NAME_NOT_NULL)
    @Size(min=4,max=20,message = ErrorMessage.NAME_SIZE)
    private String name;

    @NotNull(message= ErrorMessage.PRICE_NOT_NULL)
    @Min(value = 0, message = ErrorMessage.PRICE_TOO_LOW)
    @Max(value = 99999999, message = ErrorMessage.PRICE_TOO_HIGH)
    private Integer price;


    @NotNull(message= ErrorMessage.AMOUNT_NOT_NULL)
    @Min(value = 0, message = ErrorMessage.AMOUNT_TOO_LOW)
    @Max(value = 999999, message = ErrorMessage.AMOUNT_TOO_HIGH)
    private Integer amount;

    public ProductCreateRequest(String name, int price, int amount){

        this.name=name;
        this.price=price;
        this.amount=amount;
    }
}
