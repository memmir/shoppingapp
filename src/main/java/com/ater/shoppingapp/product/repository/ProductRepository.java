package com.ater.shoppingapp.product.repository;

import com.ater.shoppingapp.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface ProductRepository extends MongoRepository<Product, String> {
}
