package com.paytmclone.entity;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Wallet {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private double balance;

        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;
    }
