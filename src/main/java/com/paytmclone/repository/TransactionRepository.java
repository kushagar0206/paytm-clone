package com.paytmclone.repository;

import com.paytmclone.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    }
