package com.ecommerce.ecommerce_backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @NotBlank (message = "Category name is required.")
    private String name;

    @NotBlank (message = "Category description is required.")
    private String description;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
