package com.faros.EyeSpotted.exception;

public class InvalidEmailFormatException extends ValidationException{
    public InvalidEmailFormatException(String message) {
        super(message);
    }

    public InvalidEmailFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getCode() {
        return "INVALID_EMAIL_FORMAT";
    }
}
