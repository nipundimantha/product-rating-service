package com.example.productrateservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.productrateservice.model.ProductRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productrateservice.repository.ProductRateRepository;

@RestController
@RequestMapping("/api")
public class ProductRateController {

  @Autowired
  ProductRateRepository productRateRepository;

  @GetMapping("/rate/products")
  public ResponseEntity<List<ProductRate>> getAllTutorials() {
    try {
      List<ProductRate> productRates = new ArrayList<ProductRate>();

//      if (productId == null)
        productRateRepository.findAll().forEach(productRates::add);
//      else
//        tutorialRepository.findById(productId).forEach(tutorials::add);

      if (productRates.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(productRates, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/rate/products/{id}")
  public ResponseEntity<ProductRate> getTutorialById(@PathVariable("id") String id) {
    Optional<ProductRate> tutorialData = productRateRepository.findById(id);

    if (tutorialData.isPresent()) {
      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/rate/product")
  public ResponseEntity<ProductRate> createTutorial(@RequestBody ProductRate productRate) {
    try {
      ProductRate _productRate = productRateRepository.save(new ProductRate(productRate.getProductId(), productRate.getRate(), productRate.getDescription()));
      return new ResponseEntity<>(_productRate, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/rate/product/{id}")
  public ResponseEntity<ProductRate> updateTutorial(@PathVariable("id") String id, @RequestBody ProductRate productRate) {
    Optional<ProductRate> tutorialData = productRateRepository.findById(id);

    if (tutorialData.isPresent()) {
      ProductRate _productRate = tutorialData.get();
      _productRate.setDescription(productRate.getDescription());
      _productRate.setRate(productRate.getRate());
      return new ResponseEntity<>(productRateRepository.save(_productRate), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/rate/product/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
    try {
      productRateRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
