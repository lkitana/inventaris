package com.ojan.backend.inventaris.repositories;

import com.ojan.backend.inventaris.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByStockLessThanEqual(int stockIsLessThan);
}
