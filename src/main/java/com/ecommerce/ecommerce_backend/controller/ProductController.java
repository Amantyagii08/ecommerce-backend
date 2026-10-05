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
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;


@RestController  
@RequestMapping("/products")
public class ProductController {

private final ProductService productService;

public ProductController(ProductService productService){
    this.productService=productService;
}

@PostMapping 
public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){

    Product savedProduct = productService.addProduct(product);

    return ResponseEntity.status(201).body(savedProduct);
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
public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
    productService.deleteProduct(id);

    return ResponseEntity.noContent().build();
}


}
