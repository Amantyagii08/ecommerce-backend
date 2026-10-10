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
import com.ecommerce.ecommerce_backend.dto.ProductResponse;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository , CategoryRepository categoryRepository)
        {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private ProductResponse mapToResponse(Product product){
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setDescription(product.getDescription());
        response.setCategoryId(product.getCategory().getId());
        response.setCategoryName(product.getCategory().getName());
        return response;
    }

    

    
    

    public ProductResponse addProduct(ProductRequest request){
        
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow
        (()-> new CategoryNotFoundException("Category not Found."));

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setDescription(request.getDescription());
        product.setCategory(category);
        
        Product product1 = productRepository.save(product); 
        return mapToResponse(product1);
    }
    

    public List<ProductResponse> getAllProduct(){
        return productRepository.findAll()
        .stream()
        .map(this::mapToResponse)
        .toList();
    }
    
    public ProductResponse getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new 
        ProductNotFoundExcertion(
            "Product with id "+id+" not found." ));
            return mapToResponse(product);
        
    }

    public ProductResponse updateProduct(Long id, ProductRequest request){
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new 
        ProductNotFoundExcertion("Product with id "+id+" not found."));
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow
        (()-> new CategoryNotFoundException("Category not Found"));
        

        existingProduct.setName(request.getName()) ;
        existingProduct.setPrice(request.getPrice());
        existingProduct.setStock(request.getStock());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setCategory(category);

        Product product = productRepository.save(existingProduct);
        return mapToResponse(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new
        ProductNotFoundExcertion("Product with id "+id+" not found."));
        productRepository.delete(product);
    }

    
}
