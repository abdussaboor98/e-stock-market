package com.estockmarket.authservice.exception;

public class ValueAlreadyInUseException extends Exception {

    public static final String USERNAME_ALREADY_IN_USE = "The requested username is already in use.";
    public static final String EMAIL_ALREADY_IN_USE = "The requested email is already in use.";

    public ValueAlreadyInUseException(String message) {
            super(message);
        }

}
