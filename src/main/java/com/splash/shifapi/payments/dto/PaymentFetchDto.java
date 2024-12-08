package com.splash.shifapi.payments.dto;

import com.splash.shifapi.users.dto.UserFetchDto;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentFetchDto {
    private Integer id;
    private UserFetchDto user;
    private float amount;
    private Date dateOfPayment = new Date();
}
