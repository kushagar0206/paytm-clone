package com.paytmclone.dto;
import lombok.*;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class RegisterRequest {
        private String name;
        private String email;
        private String mobile;
        private String password;
    }


