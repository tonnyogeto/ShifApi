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
public class User{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
    @SequenceGenerator(name = "user_sequence_generator", sequenceName = "users_seq", allocationSize = 1)
    private Integer id;


    @Column(name="name")
    private String name;

    @Column(name="id_number")
    private String idNo;


    @Column(name="image")
    private String imagePath;

}
