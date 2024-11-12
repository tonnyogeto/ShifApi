package com.splash.ShifApi.UserPaymentPlan.dto;

import com.splash.ShifApi.UserPaymentPlan.model.PaymentPlan;

import lombok.Data;

@Data
public class UserPaymentPlanCreationDto {
    private Integer userId;
    private float Amount;
    private PaymentPlan paymentPlan;
}
