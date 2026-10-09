package com.ecommerce.ecommerce_backend.service;
import com.ecommerce.ecommerce_backend.entity.Product;
import com.ecommerce.ecommerce_backend.entity.Category;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ecommerce.ecommerce_backend.exception.ProductNotFoundExcertion;
import com.ecommerce.ecommerce_backend.dto.ProductRequest;
import com.ecommerce.ecommerce_backend.repository.CategoryRepository;
import com.ecommerce.ecommerce_backend.exception.CategoryNotFoundException;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository , CategoryRepository categoryRepository)
        {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    

    
    

    public Product addProduct(ProductRequest request){
      
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow
        (()-> new CategoryNotFoundException("Category not Found."));

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setDescription(request.getDescription());
        product.setCategory(category);
      
        return productRepository.save(product); 
    }
    
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new 
             ProductNotFoundExcertion(
            "Product with id "+id+" not found." ));
        
    }

    public Product updateProduct(Long id, ProductRequest request){
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new 
        ProductNotFoundExcertion("Product with id "+id+" not found."));
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow
        (()-> new CategoryNotFoundException("Category not Found"));
        

        existingProduct.setName(request.getName()) ;
        existingProduct.setPrice(request.getPrice());
        existingProduct.setStock(request.getStock());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setCategory(category);

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new
         ProductNotFoundExcertion("Product with id "+id+" not found."));
         productRepository.delete(product);
    }

    
}
