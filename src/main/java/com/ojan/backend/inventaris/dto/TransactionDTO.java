package com.ojan.backend.inventaris.dto;

public record TransactionDTO(
    String transactionNumber,
    long productId,
    int quantity,
    int transactionDetailId
) { }
