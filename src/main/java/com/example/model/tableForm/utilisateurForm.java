package com.example.model.tableForm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class utilisateurForm {
    @NotNull
    @Size(min=3, max=15)
    private String login;

    @NotNull
    @Size(min=3, max=15)
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Utilisateur(Login: " + this.login + ", Password: " + this.password + ")";
    }
}
