package com.java.microservicos.UserServiceAPI.errors;

public class UserValidationError extends RuntimeException {
    public UserValidationError(String message) {
        super(message);
    }
}