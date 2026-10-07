package com.ecommerce.ecommerce_backend.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler (ProductNotFoundExcertion.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundExcertion ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationErrors(
        MethodArgumentNotValidException ex){
            Map <String,String> errors = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(),error.getDefaultMessage()
            ));

            return ResponseEntity.badRequest().body(errors);
        }
    
        @ExceptionHandler (CategoryNotFoundException.class)
        public ResponseEntity<String> handleCategoryNotFound(CategoryNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
}
