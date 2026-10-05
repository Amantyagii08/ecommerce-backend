package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.service.ProductService;
import com.ecommerce.ecommerce_backend.entity.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController  
@RequestMapping("/products")
public class ProductController {

private final ProductService productService;

public ProductController(ProductService productService){
    this.productService=productService;
}

@PostMapping 
public Product addProduct(@RequestBody Product product){
    return productService.addProduct(product);
}

@GetMapping 
public List<Product>getAllProducts(){
    return productService.getAllProduct();
}

@GetMapping("/{id}")
public Product getProductById(@PathVariable long id){
    return productService.getProductById(id);
}

@PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
    return productService.updateProduct(id, product);
}

@DeleteMapping ("/{id}")
public void deleteProduct(@PathVariable Long id){
    productService.deleteProduct(id);
}


}
