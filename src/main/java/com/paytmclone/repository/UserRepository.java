package com.paytmclone.repository;

import com.paytmclone.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMobile(String mobile);
    boolean existsByMobile(String mobile);
}



