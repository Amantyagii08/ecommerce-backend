package com.ecommerce.ecommerce_backend.service;
import com.ecommerce.ecommerce_backend.entity.Category;
import com.ecommerce.ecommerce_backend.exception.CategoryNotFoundException;
import com.ecommerce.ecommerce_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new 
        CategoryNotFoundException("Category with the id "+id+" not found.") );
    }

    public Category updateCategory(Long id , Category category){
        Category existinCategory = categoryRepository.findById(id).orElseThrow(()-> new 
        CategoryNotFoundException("Category with the id "+id+" not found.") );
        if(existinCategory == null){
            return null ;
        }
        existinCategory.setName(category.getName());
        existinCategory.setDescription(category.getDescription());
        return categoryRepository.save(existinCategory);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new 
        CategoryNotFoundException("Category with the id "+id+" not found.") );

        categoryRepository.delete(category);
    }
}
