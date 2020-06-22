package com.example.model.table;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Utilisateur implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Utilisateur;
    @Column(unique = true)
    private String login;
    private String password;

    protected Utilisateur() {

    }

    public Utilisateur(String log, String pwd) {
        this.login = log;
        this.password = pwd;
    }

    @Override
    public String toString(){
        return String.format("Utilisateur=[ID_Utilisateur=%d, Login=%s, Password=%s]", this.id_Utilisateur, this.login, this.password);
    }

    public Long getID_Utilisateur() {
        return id_Utilisateur;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setID_Utilisateur(Long ID_Utilisateur) {
        this.id_Utilisateur = ID_Utilisateur;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
