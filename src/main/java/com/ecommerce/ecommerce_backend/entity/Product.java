package com.ecommerce.ecommerce_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Positive;

  @Entity 
public class Product {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @NotBlank (message ="Product name is required.")
    private String name;

    @Positive (message = "Price should be greater then Zero.")
    private double price;

    @PositiveOrZero (message = "Stock can't be negative.")
    private int stock;

    @NotBlank (message = "Product description is required.")
    private String description;
    
   
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    



  
    
}
