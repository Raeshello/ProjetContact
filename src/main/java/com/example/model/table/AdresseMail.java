package com.example.model.table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class AdresseMail implements Serializable {
    @Id
    @NotNull
    private String Libelle;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact Contact;

    protected AdresseMail(){

    }

    public AdresseMail(String libelle){
        this.Libelle = libelle;
    }

    @Override
    public String toString(){
        return String.format("AdresseMail=[Libelle='%s']", this.Libelle);
    }

    public String getLibelle() {
        return Libelle;
    }

    public Contact getContact() {
        return Contact;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public void setContact(com.example.model.table.Contact contact) {
        Contact = contact;
    }
}
