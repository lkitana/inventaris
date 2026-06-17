package com.ojan.backend.inventaris.controllers;

import com.ojan.backend.inventaris.dto.TransactionDTO;
import com.ojan.backend.inventaris.models.Transaction;
import com.ojan.backend.inventaris.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping()
    public void createTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionService.saveData(transactionDTO);
    }
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

}
