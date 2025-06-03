package com.java.microservicos.UserServiceAPI.controllers;

import com.java.microservicos.UserServiceAPI.dtos.UserDTO;
import com.java.microservicos.UserServiceAPI.errors.ErrorModelView;
import com.java.microservicos.UserServiceAPI.errors.UserValidationError;
import com.java.microservicos.UserServiceAPI.models.User;
import com.java.microservicos.UserServiceAPI.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        try {
            User user = service.save(userDTO);
            return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
        } catch (UserValidationError e) {
            return ResponseEntity.badRequest().body(new ErrorModelView(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ErrorModelView("Erro interno do servidor."));
        }
    }

    @GetMapping("/by-ids")
    public List<User> getUsersByIds(@RequestParam List<Long> ids) {
        return service.findAllByIds(ids);
    }
}