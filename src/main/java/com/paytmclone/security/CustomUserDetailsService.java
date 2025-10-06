package com.paytmclone.security;

import com.paytmclone.entity.User;
import com.paytmclone.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

    @Service
    public class CustomUserDetailsService implements UserDetailsService {

        private final UserRepository userRepo;

        public CustomUserDetailsService(UserRepository userRepo) {
            this.userRepo = userRepo;
        }

        @Override
        public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
            User user = userRepo.findByMobile(mobile);
//                    .orElseThrow(() -> new UsernameNotFoundException("User not found with mobile: " + mobile));

            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getMobile())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
        }
    }
