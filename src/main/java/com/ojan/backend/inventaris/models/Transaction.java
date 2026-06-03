package com.ojan.backend.inventaris.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String transactionNumber;
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private  TransactionDetail detail;
}
