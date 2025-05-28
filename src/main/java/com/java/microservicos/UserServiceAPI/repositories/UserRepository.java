package com.java.microservicos.UserServiceAPI.repositories;

import com.java.microservicos.UserServiceAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}