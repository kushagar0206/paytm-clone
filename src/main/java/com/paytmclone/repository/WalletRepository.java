package com.paytmclone.repository;

import com.paytmclone.entity.User;
import com.paytmclone.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface WalletRepository extends JpaRepository<Wallet, Long> {
        Wallet findByUser(User user);
    }
