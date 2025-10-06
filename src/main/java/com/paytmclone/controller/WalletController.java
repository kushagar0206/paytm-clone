package com.paytmclone.controller;

import com.paytmclone.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/create/{mobile}")
    public String createWallet(@PathVariable String mobile) {
        walletService.createWallet(mobile);
        return "Wallet created successfully!";
    }

    @PostMapping("/addMoney")
    public String addMoney(@RequestParam String mobile, @RequestParam double amount) {
        return walletService.addMoney(mobile, amount);
    }

    @PostMapping("/sendMoney")
    public String sendMoney(@RequestParam String sender, @RequestParam String receiver, @RequestParam double amount) {
        return walletService.sendMoney(sender, receiver, amount);
    }

    @GetMapping("/balance/{mobile}")
    public String checkBalance(@PathVariable String mobile) {
        return "Available balance: ₹" + walletService.checkBalance(mobile);
    }
}