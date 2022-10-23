package com.example.eTaskify_ver1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException{

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }
}
