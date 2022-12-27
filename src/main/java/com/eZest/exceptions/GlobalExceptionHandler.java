package com.eZest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<String> vehicleNotFoundException(VehicleNotFoundException vehicleNotFoundException)
    {
        String message = vehicleNotFoundException.getMessage();
        return  new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(VehicleAlreadyExistsException.class)
    public ResponseEntity<String> vehicleAlreadyExistsException(VehicleAlreadyExistsException vehicleAlreadyExistsException)
    {
        String message = vehicleAlreadyExistsException.getMessage();
        return  new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);

    }

}
