package com.example.productrateservice.repository;

import com.example.productrateservice.model.ProductRate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRateRepository extends MongoRepository<ProductRate, String> {
//  List<Tutorial> findByPublished(boolean published);
//  List<Tutorial> findByTitleContaining(String title);
}
