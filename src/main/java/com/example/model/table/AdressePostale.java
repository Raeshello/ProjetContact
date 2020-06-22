package com.example.model.table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class AdressePostale implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_AdressePostale;

    private String Libelle;

    @ManyToMany(mappedBy = "ListAdress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Contact> ListContact;

    protected AdressePostale(){
    }

    public AdressePostale(String libelle){
        this.Libelle = libelle;
    }

    @Override
    public String toString(){
        String ListOfContact = "{";
        boolean firstEntry = true;
        for(Contact e : ListContact){
            if(firstEntry){
                ListOfContact += e.getID_Contact().toString();
                firstEntry = false;
            } else {
                ListOfContact += ", " + e.getID_Contact().toString();
            }
        }
        ListOfContact += "}";
        return String.format("AdressePostale=[ID_AdressePostale=%d, Libelle='%s', ListContact=%s]", this.ID_AdressePostale, this.Libelle, ListOfContact);
    }

    public Long getID_AdressePostale() {
        return ID_AdressePostale;
    }

    public String getLibelle() {
        return Libelle;
    }

    public Collection<Contact> getListContact() {
        return ListContact;
    }

    public void setID_AdressePostale(Long ID_AdressePostale) {
        this.ID_AdressePostale = ID_AdressePostale;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public void setListContact(Collection<Contact> listContact) {
        ListContact = listContact;
    }
}
