package com.estockmarket.authservice.exception;

public class NotFoundException extends Exception {

    public static final String USER_NOT_FOUND = "The requested user is not found";

    public NotFoundException(String message) {
        super(message);
    }
}
