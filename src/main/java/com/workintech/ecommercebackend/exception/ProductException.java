package com.workintech.ecommercebackend.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends RuntimeException{
    private HttpStatus httpStatus;

    public ProductException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
