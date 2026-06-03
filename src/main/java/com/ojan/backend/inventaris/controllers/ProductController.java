package com.ojan.backend.inventaris.controllers;

import com.ojan.backend.inventaris.dto.ProductDTO;
import com.ojan.backend.inventaris.models.Product;
import com.ojan.backend.inventaris.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProduct();
    }

    @PostMapping()
    public void addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        productService.updateProduct(id, productDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/low-stock")
    public List<Product> getLowStockProducts(){
        return productService.getProductLowStock();
    }
}
