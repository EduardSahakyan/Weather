package org.example.common.exceptions;

public class IncorrectPasswordException extends Exception {

    private final String message;

    public IncorrectPasswordException(String message) {
        super(message);
        this.message = message;
    }
}
