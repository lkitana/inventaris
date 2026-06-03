package com.ojan.backend.inventaris.dto;

public record TransactionDetailDTO(
   int quantity,
   double totalPrice,
   long transactionId,
   long productId
) {}
