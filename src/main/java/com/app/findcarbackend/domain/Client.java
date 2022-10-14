package com.app.findcarbackend.domain;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CLIENTS")
public class Client {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "CLIENT_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "LOGIN_STATUS")
    private LoginStatus loginStatus;

    @ManyToMany
    @JoinColumn(name = 'CAR_ID')
    private Car car;

    @OneToMany
    @JoinColumn(name = 'RENT_ID')
    private Rent rent;
}
