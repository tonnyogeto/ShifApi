package com.splash.ShifApi.claims.model;

import com.splash.ShifApi.hospitalVisits.model.HospitalVisit;
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
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claim_sequence_generator")
    @SequenceGenerator(name = "claim_sequence_generator", sequenceName = "claims_seq", allocationSize = 1)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne
    @JoinColumn(name="hospital_visit_id")
    private HospitalVisit hospitalVisit;




}
