package com.ojan.backend.inventaris.services;

import com.ojan.backend.inventaris.dto.TransactionDTO;
import com.ojan.backend.inventaris.models.Product;
import com.ojan.backend.inventaris.models.Transaction;
import com.ojan.backend.inventaris.models.TransactionDetail;
import com.ojan.backend.inventaris.repositories.ProductRepo;
import com.ojan.backend.inventaris.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    TransactionRepo transactionRepo;

    public Product getProductById(TransactionDTO transactionDTO) {
        return productRepo.findById(transactionDTO.productId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, transactionDTO.productId() + " not found")
        );
    }

    public void checkProductStock(TransactionDTO transactionDTO) {
        if(getProductById(transactionDTO).getStock() < transactionDTO.quantity()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Stock tidak mencukupi Stok saat ini: " + getProductById(transactionDTO).getStock());
    }

    public double calculateTotalPrice(TransactionDTO transactionDTO) {
        return transactionDTO.quantity() * productRepo.findById(transactionDTO.productId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found")
        ).getPrice();
    }

    public void calculateProductStock(TransactionDTO transactionDTO) {
        checkProductStock(transactionDTO);

        Product product = getProductById(transactionDTO);
        int newStock = product.getStock() - transactionDTO.quantity();
        product.setStock(newStock);
        productRepo.save(product);
    }

    public void saveData(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        TransactionDetail transactionDetail = new TransactionDetail();
        transaction.setCreatedAt(LocalDateTime.now());
        transactionDetail.setProduct(productRepo.findById(transactionDTO.productId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found")
        ));
        transactionDetail.setQuantity(transactionDTO.quantity());
        transactionDetail.setTotalPrice(calculateTotalPrice(transactionDTO));
        transaction.setDetail(transactionDetail);
        transactionRepo.save(transaction);
    }
}
