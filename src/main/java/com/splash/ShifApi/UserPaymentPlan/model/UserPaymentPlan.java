package com.splash.ShifApi.UserPaymentPlan.model;

import com.splash.ShifApi.infrastructure.entityutils.Identifiable;
import com.splash.ShifApi.users.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_payment_plan")
public class UserPaymentPlan extends Identifiable {

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private float Amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_plan")
    private PaymentPlan paymentPlan;

}
