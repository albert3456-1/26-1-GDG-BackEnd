package com.example.shop.member.dto;

import com.example.shop.common.message.ErrorMessage;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberUpdateRequest {

    @Size(min=8,max=20,message = ErrorMessage.PASSWORD_SIZE)
    private String password;

    @Pattern(regexp = "^010-\\d{4}-\\d{4}$",message = ErrorMessage.PHONENUMBER_WRONG_PATTERN)
    private String phoneNumber;

    @Size(min=4,max=50,message = ErrorMessage.ADDRESS_SIZE)
    private String address;

    public MemberUpdateRequest(String password, String phoneNumber, String address){
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
}
