package com.ecommerce.ecommerce_backend.controller;
import com.ecommerce.ecommerce_backend.service.ProductService;
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
import com.ecommerce.ecommerce_backend.dto.ProductRequest;
import com.ecommerce.ecommerce_backend.dto.ProductResponse;


@RestController  
@RequestMapping("/products")
public class ProductController {

private final ProductService productService;

public ProductController(ProductService productService){
    this.productService=productService;
}

@PostMapping 
public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody ProductRequest request){

    ProductResponse response = productService.addProduct(request);

    return ResponseEntity.status(201).body(response);
}

@GetMapping 
public List<ProductResponse>getAllProducts(){
    return productService.getAllProduct();
}

@GetMapping("/{id}")
public ProductResponse getProductById(@PathVariable long id){
    return productService.getProductById(id);
}

@PutMapping("/{id}")
public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest request){
    return productService.updateProduct(id, request);
}

@DeleteMapping ("/{id}")
public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
    productService.deleteProduct(id);

    return ResponseEntity.noContent().build();
}


}
