package com.interview.test.exceptions;

import lombok.Data;

@Data
public class ErrorDto {
    private String message;
    private int statusCode;
}
