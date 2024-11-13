package com.splash.ShifApi.payments.dto;

import com.splash.ShifApi.users.dto.UserFetchDto;
import com.splash.ShifApi.users.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentFetchDto {
    private UserFetchDto user;
    private float amount;
    private Date dateOfPayment = new Date();
}
