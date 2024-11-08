package com.splash.ShifApi.payments.model;

import com.splash.ShifApi.infrastructure.entityutils.Identifiable;
import com.splash.ShifApi.users.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class Payment extends Identifiable {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="amount")
    private float amount;

    @Column(name="date")
    final Date currentDate = new Date();

}
