package com.paytmclone.service;

import com.paytmclone.entity.*;
import com.paytmclone.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

    @Service
    public class WalletService {

        @Autowired
        private WalletRepository walletRepo;
        @Autowired
        private UserRepository userRepo;
        @Autowired
        private TransactionRepository transactionRepo;

        public Wallet createWallet(String mobile) {
            User user = userRepo.findByMobile(mobile);
            Wallet wallet = new Wallet();
            wallet.setUser(user);
            wallet.setBalance(0.0);
            return walletRepo.save(wallet);
        }

        public String addMoney(String mobile, double amount) {
            User user = userRepo.findByMobile(mobile);
            Wallet wallet = walletRepo.findByUser(user);
            wallet.setBalance(wallet.getBalance() + amount);
            walletRepo.save(wallet);

            Transaction txn = new Transaction(null, "CREDIT", amount, "Added Money", LocalDateTime.now(), wallet);
            transactionRepo.save(txn);

            return "₹" + amount + " added successfully!";
        }

        public String sendMoney(String senderMobile, String receiverMobile, double amount) {
            User sender = userRepo.findByMobile(senderMobile);
            User receiver = userRepo.findByMobile(receiverMobile);

            Wallet senderWallet = walletRepo.findByUser(sender);
            Wallet receiverWallet = walletRepo.findByUser(receiver);

            if (senderWallet.getBalance() < amount)
                return "Insufficient balance!";

            senderWallet.setBalance(senderWallet.getBalance() - amount);
            receiverWallet.setBalance(receiverWallet.getBalance() + amount);

            walletRepo.save(senderWallet);
            walletRepo.save(receiverWallet);

            transactionRepo.save(new Transaction(null, "DEBIT", amount, "Sent to " + receiver.getName(), LocalDateTime.now(), senderWallet));
            transactionRepo.save(new Transaction(null, "CREDIT", amount, "Received from " + sender.getName(), LocalDateTime.now(), receiverWallet));

            return "₹" + amount + " sent to " + receiver.getName() + " successfully!";
        }

        public double checkBalance(String mobile) {
            User user = userRepo.findByMobile(mobile);
            Wallet wallet = walletRepo.findByUser(user);
            return wallet.getBalance();
        }
    }
