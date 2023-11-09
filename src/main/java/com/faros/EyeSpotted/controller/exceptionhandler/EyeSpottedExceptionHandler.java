package com.faros.EyeSpotted.controller.exceptionhandler;

import com.faros.EyeSpotted.exception.ValidationException;
import com.faros.EyeSpotted.exception.error.EyeSpottedError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class EyeSpottedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body(new EyeSpottedError(e.getCode()));
    }
}
