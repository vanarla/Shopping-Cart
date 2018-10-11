package com.capgemini.shoppingcartapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.shoppingcartapp.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

}
