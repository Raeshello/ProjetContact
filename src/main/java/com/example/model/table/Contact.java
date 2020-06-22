package com.example.model.table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Contact implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Contact;

    @Column(unique = true)
    private String nom;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Appartient",
            joinColumns = @JoinColumn(name = "ID_Contact"),
            inverseJoinColumns = @JoinColumn(name = "ID_AdressePostale")
    )
    private Collection<AdressePostale> ListAdress;

    @OneToMany(mappedBy = "Contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<AdresseMail> ListMail;

    protected Contact(){

    }

    public Contact(String name){
        this.nom = name;
    }

    @Override
    public String toString() {
        String ListOfAdress = "{";
        boolean firstEntry = true;
        for(AdressePostale e : ListAdress){
            if(firstEntry){
                ListOfAdress += e.getID_AdressePostale().toString();
                firstEntry = false;
            } else {
                ListOfAdress += ", " + e.getID_AdressePostale().toString();
            }
        }
        ListOfAdress += "}";

        String ListOfMail = "{";
        firstEntry = true;
        for(AdresseMail e : ListMail){
            if(firstEntry){
                ListOfMail += e.getLibelle();
                firstEntry = false;
            } else {
                ListOfMail += ", " + e.getLibelle();
            }
        }
        ListOfMail += "}";

        return String.format("Contact[ID_Contact=%d, Nom='%s', ListAdress=%s, ListMail=%s]", id_Contact, nom, ListOfAdress, ListOfMail);
    }

    public Long getID_Contact() {
        return id_Contact;
    }

    public String getNom() {
        return nom;
    }

    public Collection<AdressePostale> getListAdress() {
        return ListAdress;
    }

    public Collection<AdresseMail> getListMail() {
        return ListMail;
    }

    public void setID_Contact(Long ID_Contact) {
        this.id_Contact = ID_Contact;
    }

    public void setNom(String nom) {
        nom = nom;
    }

    public void setListAdress(Collection<AdressePostale> listAdress) {
        ListAdress = listAdress;
    }

    public void setListMail(Collection<AdresseMail> listMail) {
        ListMail = listMail;
    }
}
