package com.splash.ShifApi.infrastructure.exceptions;

import com.splash.ShifApi.infrastructure.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(
            ResourceNotFoundException ex
    ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ApiResponse<>(ex.getMessage(), null)
        );
    }


}
