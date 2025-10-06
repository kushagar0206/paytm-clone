package com.paytmclone.controller;

import com.paytmclone.dto.*;
import com.paytmclone.entity.*;
import com.paytmclone.repository.UserRepository;
import com.paytmclone.repository.WalletRepository;
import com.paytmclone.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

    @RestController
    @RequestMapping("/auth")
    public class AuthController {

        private final AuthenticationManager authenticationManager;
        private final UserRepository userRepo;
        private final JwtUtil jwtUtil;
        private final PasswordEncoder passwordEncoder;
        private final WalletRepository walletRepo;

        public AuthController(AuthenticationManager authenticationManager,
                              UserRepository userRepo,
                              JwtUtil jwtUtil,
                              PasswordEncoder passwordEncoder,
                              WalletRepository walletRepo) {
            this.authenticationManager = authenticationManager;
            this.userRepo = userRepo;
            this.jwtUtil = jwtUtil;
            this.passwordEncoder = passwordEncoder;
            this.walletRepo = walletRepo;
        }

        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
            if (userRepo.existsByMobile(req.getMobile())) {
                return ResponseEntity.badRequest().body("Mobile already in use.");
            }

            User user = new User();
            user.setName(req.getName());
            user.setEmail(req.getEmail());
            user.setMobile(req.getMobile());
            user.setPassword(passwordEncoder.encode(req.getPassword()));
            user.setRole("USER");
            userRepo.save(user);

            // Create wallet for new user
            var wallet = new com.paytmclone.entity.Wallet();
            wallet.setUser(user);
            wallet.setBalance(0.0);
            walletRepo.save(wallet);

            return ResponseEntity.ok("User registered successfully");
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody com.paytmclone.dto.AuthRequest req) {
            try {
                var authToken = new UsernamePasswordAuthenticationToken(req.getMobile(), req.getPassword());
                authenticationManager.authenticate(authToken);

                String token = jwtUtil.generateToken(req.getMobile());
                return ResponseEntity.ok(new AuthResponse(token));
            } catch (BadCredentialsException ex) {
                return ResponseEntity.status(401).body("Invalid mobile or password");
            }
        }
    }

