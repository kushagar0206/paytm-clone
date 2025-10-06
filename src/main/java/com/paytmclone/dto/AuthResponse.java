package com.paytmclone.dto;
import lombok.*;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AuthResponse {
        private String token;
        private String tokenType = "Bearer";

        public AuthResponse(String token) {
        }
    }

