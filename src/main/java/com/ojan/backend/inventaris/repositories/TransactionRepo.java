package com.ojan.backend.inventaris.repositories;

import com.ojan.backend.inventaris.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}
