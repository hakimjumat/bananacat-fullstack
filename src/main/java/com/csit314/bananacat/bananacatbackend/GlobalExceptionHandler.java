package com.csit314.bananacat.bananacatbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Boolean> EnumMismatch (MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.ok(false);
    }
}
