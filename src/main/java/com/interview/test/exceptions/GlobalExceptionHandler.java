package com.interview.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(QuizNotFoundException.class)
    public ResponseEntity<ErrorDto> handleQuizNotFoundException(QuizNotFoundException e){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage(e.getMessage());
        errorDto.setStatusCode(400);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
