package com.app.findcarbackend.domain;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CLIENTS")
public class Client {

    private List<Rent> rents = new ArrayList<>();

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

    @OneToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rent> getRents() {
        return rents;
    }
}
