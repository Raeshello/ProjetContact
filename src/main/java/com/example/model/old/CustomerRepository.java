package com.example.model.old;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Jason Mahdjoub
 * @version 1.0
 * @since SpringBoot
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}
