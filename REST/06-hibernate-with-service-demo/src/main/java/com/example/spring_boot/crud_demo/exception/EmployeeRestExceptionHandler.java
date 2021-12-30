package com.example.spring_boot.crud_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
    //add an exceptional handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception){
        EmployeeErrorResponse customerErrorResponse = new EmployeeErrorResponse();
        customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customerErrorResponse.setMessage(exception.getMessage());
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(customerErrorResponse,HttpStatus.NOT_FOUND);
    }

    // add another exception handler .... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception){
        EmployeeErrorResponse customerErrorResponse = new EmployeeErrorResponse();
        customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customerErrorResponse.setMessage(exception.getMessage());
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(customerErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
