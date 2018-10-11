package com.capgemini.shoppingcartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.shoppingcartapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
