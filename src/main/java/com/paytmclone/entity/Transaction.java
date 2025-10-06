package com.paytmclone.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String type; // CREDIT or DEBIT
        private double amount;
        private String description;
        private LocalDateTime dateTime;

        @ManyToOne
        @JoinColumn(name = "wallet_id")
        private Wallet wallet;
    }
