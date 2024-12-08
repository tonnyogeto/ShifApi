package com.splash.shifapi.payments.model;


import com.splash.shifapi.users.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payments")
public class Payment{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence_generator")
    @SequenceGenerator(name = "payment_sequence_generator", sequenceName = "payments_seq", allocationSize = 1)
    private Integer id;




    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="amount_paid")
    private float amount;

    @Column(name="date")
    private Date dateOfPayment = new Date();

}
