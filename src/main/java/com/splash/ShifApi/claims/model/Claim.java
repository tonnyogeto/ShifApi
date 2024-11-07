package com.splash.ShifApi.claims.model;

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
@Table(name="claims")
public class Claim {

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;




}
