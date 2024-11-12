package com.splash.ShifApi.UserPaymentPlan.dto;

import com.splash.ShifApi.UserPaymentPlan.model.PaymentPlan;
import com.splash.ShifApi.users.dto.UserFetchDto;
import lombok.Data;

@Data
public class UserPaymentPlanFetchDto {
    private UserFetchDto user;
    private float Amount;
    private PaymentPlan paymentPlan;
}
