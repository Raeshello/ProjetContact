package com.example.model.table;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByNom(String nom);

    Contact findById(long id_Contact);

    Iterable<Contact> findAll();

    void deleteByid_Contact(long id_Contact);

}
