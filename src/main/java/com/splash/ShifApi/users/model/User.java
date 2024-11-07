package com.splash.ShifApi.users.model;


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
@Table(name="users")
public class User {

    @Column(name="name")
    private String name;

    @Column(name="id_number")
    private String idNo;

    @Lob
    @Column(name="image")
    private byte[] image;

}
