package com.workintech.ecommercebackend.exception;

import org.springframework.http.HttpStatus;

public class EcommerceException  extends RuntimeException {
    private HttpStatus httpStatus;

    public EcommerceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
