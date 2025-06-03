package com.java.microservicos.UserServiceAPI.services;

import com.java.microservicos.UserServiceAPI.models.User;
import com.java.microservicos.UserServiceAPI.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public List<User> findAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
}