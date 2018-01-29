package com.johncnstn.exception;

public class EmailExistsException extends Exception {
    public EmailExistsException(String message) {
        super(message);
    }
}
