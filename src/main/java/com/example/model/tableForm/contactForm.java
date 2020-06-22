package com.example.model.tableForm;

import com.example.model.table.AdresseMail;
import com.example.model.table.AdressePostale;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

public class contactForm {
    @NotNull
    @Size(min=3, max=254)
    private String name;

    private Collection<AdresseMail> ListMail;
    private Collection<AdressePostale> ListAdress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<AdresseMail> getListMail() {
        return ListMail;
    }

    public void setListMail(Collection<AdresseMail> listMail) {
        ListMail = listMail;
    }

    public Collection<AdressePostale> getListAdress() {
        return ListAdress;
    }

    public void setListAdress(Collection<AdressePostale> listAdress) {
        ListAdress = listAdress;
    }

    public String toString() {
        return "Contact(Login: " + this.name + ")";
    }
}
