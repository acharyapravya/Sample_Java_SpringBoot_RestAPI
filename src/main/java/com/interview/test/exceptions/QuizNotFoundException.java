package com.interview.test.exceptions;

public class QuizNotFoundException extends Exception{

    private String message;

    public QuizNotFoundException(String message){
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
