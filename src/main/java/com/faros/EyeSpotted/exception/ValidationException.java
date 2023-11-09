package com.faros.EyeSpotted.exception;

public abstract class ValidationException extends EyeSpottedException{
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
