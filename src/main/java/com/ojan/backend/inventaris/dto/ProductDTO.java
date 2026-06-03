package com.ojan.backend.inventaris.dto;

public record ProductDTO(
         String name,
         String sku,
         double price,
         int stock,
         long categoryId
) {}