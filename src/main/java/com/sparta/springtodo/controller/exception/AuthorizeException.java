package com.sparta.springtodo.controller.exception;

public class AuthorizeException extends RuntimeException {
    public AuthorizeException(String message) {
        super(message);
    }
}
