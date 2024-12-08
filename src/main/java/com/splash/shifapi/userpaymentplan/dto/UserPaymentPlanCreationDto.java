package com.splash.shifapi.userpaymentplan.dto;

import com.splash.shifapi.userpaymentplan.model.PaymentPlan;

import lombok.Data;

@Data
public class UserPaymentPlanCreationDto {
    private Integer userId;
    private float Amount;
    private PaymentPlan paymentPlan;
}
