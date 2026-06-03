package com.ojan.backend.inventaris.controllers;

import com.ojan.backend.inventaris.dto.TransactionDTO;
import com.ojan.backend.inventaris.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping()
    public void createTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionService.saveData(transactionDTO);
    }

}
