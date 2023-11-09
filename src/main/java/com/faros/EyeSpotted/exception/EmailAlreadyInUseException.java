package com.faros.EyeSpotted.exception;

public class EmailAlreadyInUseException extends ValidationException{
    public EmailAlreadyInUseException(String message) {
        super(message);
    }

    public EmailAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getCode() {
        return "EMAIL_ALREADY_IN_USE";
    }
}
