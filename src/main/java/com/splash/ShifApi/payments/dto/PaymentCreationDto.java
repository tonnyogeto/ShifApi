package com.splash.ShifApi.payments.dto;

import lombok.Data;

@Data
public class PaymentCreationDto {
    private Integer userId;
    private float amount;
}
