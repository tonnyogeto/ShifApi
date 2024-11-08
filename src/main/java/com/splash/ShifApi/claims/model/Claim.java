package com.splash.ShifApi.claims.model;

import com.splash.ShifApi.hospitalVisits.model.HospitalVisit;
import com.splash.ShifApi.infrastructure.entityutils.Identifiable;
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
public class Claim extends Identifiable {

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne
    @JoinColumn(name="hospital_visit_id")
    private HospitalVisit hospitalVisit;




}
