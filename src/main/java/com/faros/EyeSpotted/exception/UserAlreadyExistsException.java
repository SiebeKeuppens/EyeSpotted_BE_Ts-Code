package com.faros.EyeSpotted.exception;

public class UserAlreadyExistsException extends ValidationException{
    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getCode() {
        return "USERNAME_UNAVAILABLE";
    }
}
