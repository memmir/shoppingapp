package com.ater.shoppingapp.product.repository;

import com.ater.shoppingapp.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
