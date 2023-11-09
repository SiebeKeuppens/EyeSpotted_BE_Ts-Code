package com.faros.EyeSpotted.exception;

public abstract class EyeSpottedException extends RuntimeException {
    public EyeSpottedException(String message) {
        super(message);
    }

    public EyeSpottedException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract String getCode();
}
