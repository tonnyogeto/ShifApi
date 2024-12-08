package com.splash.shifapi.userpaymentplan.dto;

import com.splash.shifapi.userpaymentplan.model.PaymentPlan;
import com.splash.shifapi.users.dto.UserFetchDto;
import lombok.Data;

@Data
public class UserPaymentPlanFetchDto {
    private UserFetchDto user;
    private float Amount;
    private PaymentPlan paymentPlan;
}
