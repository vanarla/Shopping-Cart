package com.capgemini.shoppingcartapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.shoppingcartapp.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
