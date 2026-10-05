package com.ecommerce.ecommerce_backend.service;
import com.ecommerce.ecommerce_backend.entity.Product;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ecommerce.ecommerce_backend.exception.ProductNotFoundExcertion;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product){
      return  productRepository.save(product);
    }
    
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new 
             ProductNotFoundExcertion(
            "Product with id "+id+" not found." ));
        
    }

    public Product updateProduct(Long id, Product product){
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new 
        ProductNotFoundExcertion("Product with id "+id+" not found."));
        if(existingProduct==null){
            return null;
        }

        existingProduct.setName(product.getName()) ;
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setDescription(product.getDescription());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new
         ProductNotFoundExcertion("Product with id "+id+" not found."));
         productRepository.delete(product);
    }

    
}
