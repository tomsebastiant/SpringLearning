package com.tomsebastiant.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller advice allows you preprocess requests and post process responses globally
// Global level exception handling can be done here
// More relevant for large projects and enterprise applications

@ControllerAdvice
public class StudentRestExceptionHandler {

    //  Add exception handler class for specific error.

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        StudentErrorResponse ser = new StudentErrorResponse();
        ser.setStatus(HttpStatus.NOT_FOUND.value());
        ser.setMessage(exc.getMessage());
        ser.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(ser,HttpStatus.NOT_FOUND);
    }

//  Add exception handler class as catch all.

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse ser = new StudentErrorResponse();
        ser.setStatus(HttpStatus.BAD_REQUEST.value());
        ser.setMessage(exc.getMessage());
        ser.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(ser,HttpStatus.BAD_REQUEST);
    }
}
