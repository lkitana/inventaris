package com.ojan.backend.inventaris.repositories;

import com.ojan.backend.inventaris.models.Product;
import com.ojan.backend.inventaris.models.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailRepo extends JpaRepository<TransactionDetail,Long> {
    public Product getProductById(long id);
}