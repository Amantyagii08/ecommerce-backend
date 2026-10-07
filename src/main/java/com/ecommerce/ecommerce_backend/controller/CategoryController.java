package com.ecommerce.ecommerce_backend.controller;
import com.ecommerce.ecommerce_backend.service.CategoryService;
import com.ecommerce.ecommerce_backend.entity.Category;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping 
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category){
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.status(201).body(savedCategory);
    }
    
    @GetMapping 
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    
    @GetMapping ("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping ("/{id}")
    public Category updateCategory(@PathVariable Long id ,@RequestBody  Category category){
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();

    }
    
}
