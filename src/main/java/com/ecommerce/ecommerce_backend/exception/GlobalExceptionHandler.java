package com.ecommerce.ecommerce_backend.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler (ProductNotFoundExcertion.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundExcertion ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
}
