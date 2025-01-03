package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> exceptionHandler(PlantException plantException) {
        log.error("Plant exception ocurred ", plantException);
        PlantErrorResponse response = new PlantErrorResponse(plantException.getHttpStatus().value(), plantException.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(response, plantException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> exceptionHandler(Exception exception) {
        log.error("Plant exception ocurred ", exception);
        PlantErrorResponse response = new PlantErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
