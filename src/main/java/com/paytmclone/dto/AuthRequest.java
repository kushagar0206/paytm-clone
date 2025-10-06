package com.paytmclone.dto;

import lombok.*;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AuthRequest {
        private String mobile;
        private String password;
}
