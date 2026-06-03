package com.ojan.backend.inventaris.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String sku;
    private double price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
