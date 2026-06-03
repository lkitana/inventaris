package com.ojan.backend.inventaris.services;

import com.ojan.backend.inventaris.dto.ProductDTO;
import com.ojan.backend.inventaris.models.Product;
import com.ojan.backend.inventaris.repositories.CategoryRepo;
import com.ojan.backend.inventaris.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public List<Product> getProduct() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found")
        );
    }

    public void addProduct(ProductDTO product){
        productRepo.save(Product.builder()
                .name(product.name())
                .sku(product.sku())
                .price(product.price())
                .stock(product.stock())
                .category(categoryRepo.findById(product.categoryId()).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found")
                ))
                .build());
    }

    public void updateProduct(long id, ProductDTO productDTO){
        if(!productRepo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        productRepo.save(Product.builder()
                .id(id)
                .name(productDTO.name())
                .sku(productDTO.sku())
                .price(productDTO.price())
                .stock(productDTO.stock())
                .category(categoryRepo.findById(productDTO.categoryId()).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found")
                ))
                .build());
    }

    public void deleteProduct(Long id) {
        if(!productRepo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        productRepo.deleteById(id);
    }

    public List<Product> getProductLowStock(){
        if(productRepo.findByStockLessThanEqual(5).isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        return productRepo.findByStockLessThanEqual(5);
    }

}
