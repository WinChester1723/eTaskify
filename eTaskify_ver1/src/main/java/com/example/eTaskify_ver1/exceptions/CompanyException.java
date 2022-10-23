package com.example.eTaskify_ver1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyException extends RuntimeException{

    public CompanyException() {
    }

    public CompanyException(String message) {
        super(message);
    }
}
