package com.example.eTaskify_ver1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskStatusEnumException extends RuntimeException{
    public TaskStatusEnumException() {
    }

    public TaskStatusEnumException(String message) {
        super(message);
    }
}
