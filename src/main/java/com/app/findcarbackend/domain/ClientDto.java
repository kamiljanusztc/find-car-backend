package com.app.findcarbackend.domain;

public class ClientDto {
    private long id;
    private String name;
    private String surname;
    private String login;
    private String email;
    private LoginStatus loginStatus;

    public ClientDto(long id, String name, String surname, String login, String email, LoginStatus loginStatus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.loginStatus = loginStatus;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }
}
