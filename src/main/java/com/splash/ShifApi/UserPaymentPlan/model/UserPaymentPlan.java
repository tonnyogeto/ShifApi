package com.splash.ShifApi.UserPaymentPlan.model;


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
public class UserPaymentPlan{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_payment_plan_sequence_generator")
    @SequenceGenerator(name = "user_payment_plan_sequence_generator", sequenceName = "user_payment_plan_seq", allocationSize = 1)
    private Integer id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private float Amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_plan")
    private PaymentPlan paymentPlan;

}
