package com.app.findcarbackend.domain;

import javax.validation.constraints.NotNull;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CLIENTS")
public class Client {

    @NotNull
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private String name;

    private String surname;

    private String login;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private LoginStatus loginStatus;
}
