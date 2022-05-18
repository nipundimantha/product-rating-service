package com.example.productrateservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productRate")
public class ProductRate {
  @Id
  private String id;

  private String productId;
  private String rate;
  private String description;

  public ProductRate() {

  }

  public ProductRate(String productId, String rate, String description) {
    this.productId = productId;
    this.rate = rate;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
