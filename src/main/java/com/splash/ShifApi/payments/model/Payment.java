package com.splash.ShifApi.payments.model;

import com.splash.ShifApi.users.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Payment {

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="amount")
    private float amount;
}
