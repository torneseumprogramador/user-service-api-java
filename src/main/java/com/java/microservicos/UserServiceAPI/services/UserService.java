package com.java.microservicos.UserServiceAPI.services;

import com.java.microservicos.UserServiceAPI.models.User;
import com.java.microservicos.UserServiceAPI.dtos.UserDTO;
import com.java.microservicos.UserServiceAPI.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.java.microservicos.UserServiceAPI.errors.UserValidationError;

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

    public User save(UserDTO userDTO) {
        if (userDTO.getName() == null || userDTO.getName().trim().isEmpty()) {
            throw new UserValidationError("O nome é obrigatório.");
        }
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            throw new UserValidationError("O email é obrigatório.");
        }
        // Validação simples de formato de email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!userDTO.getEmail().matches(emailRegex)) {
            throw new UserValidationError("O email está em formato inválido.");
        }
        // Verifica se o email já existe
        if (repository.findByEmail(userDTO.getEmail()) != null) {
            throw new UserValidationError("O email já está cadastrado.");
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return repository.save(user);
    }

    public List<User> findAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
}