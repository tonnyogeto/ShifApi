package com.splash.ShifApi.payments.model;


import com.splash.ShifApi.users.model.User;
import jakarta.persistence.*;

import java.util.Date;

public class Payment{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence_generator")
    @SequenceGenerator(name = "payment_sequence_generator", sequenceName = "payments_seq", allocationSize = 1)
    private Integer id;




    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="amount")
    private float amount;

    @Column(name="date")
    final Date currentDate = new Date();

}
