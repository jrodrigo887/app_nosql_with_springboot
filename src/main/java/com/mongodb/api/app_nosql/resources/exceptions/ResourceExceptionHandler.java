package com.mongodb.api.app_nosql.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongodb.api.app_nosql.services.ObjectNotFoundError;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundError.class)
    public ResponseEntity<StandardError> resourceNotFound(ObjectNotFoundError e, ServletRequest request) {
        String error = "Not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), e.getMessage(), status.value(), error, request.getRequestId());

        return ResponseEntity.status(status).body(err);
    }
}