package com.example.eTaskify_ver1.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum {

    INVALID_PASSWORD("Your password is not valid. Please set at least 6 AlphaNumeric characters"),
    INVALID_PASSWORD_LENGTH("Yor password length does not match"),
    INVALID_ORGANIZATION("Company not found"),
    INVALID_USER("Employee not found"),
    INVALID_TASK("Task not found"),
    INVALID_TASK_STATUS_ENUM("Task status not found");

    private final String message;

    public String getMessage() {
        return message;
    }

    public String getMessage(long id) {
        return getMessage(String.valueOf(id));
    }

    public String getMessage(String text) {
        return String.join(" ", text, message);
    }
}
