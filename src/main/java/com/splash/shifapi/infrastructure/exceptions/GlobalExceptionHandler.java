package com.splash.shifapi.infrastructure.exceptions;

import com.splash.shifapi.infrastructure.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(
            BadRequestException ex
    ){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ApiResponse<>(ex.getMessage(),null)
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public  ResponseEntity<?> handleResourceNotFoundException(
            ResourceNotFoundException ex
    ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ApiResponse<>(ex.getMessage(),null)
        );
    }

    @ExceptionHandler(ConflictException.class)
    public  ResponseEntity<?> handleConflictException(
            ConflictException ex
    ){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ApiResponse<>(ex.getMessage(),null)
        );
    }



}
