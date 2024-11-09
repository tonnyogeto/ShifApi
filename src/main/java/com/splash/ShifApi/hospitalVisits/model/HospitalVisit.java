package com.splash.ShifApi.hospitalVisits.model;

import com.splash.ShifApi.infrastructure.entityutils.Identifiable;
import com.splash.ShifApi.users.model.User;
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
@Table(name="hospital_visits")
public class HospitalVisit extends Identifiable {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="date")
    private Date currentDate= new Date(System.currentTimeMillis());


}
