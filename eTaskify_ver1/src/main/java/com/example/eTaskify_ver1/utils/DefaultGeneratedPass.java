package com.example.eTaskify_ver1.utils;

import com.example.eTaskify_ver1.exceptions.PasswordLengthException;
import com.example.eTaskify_ver1.model.enums.ErrorMessageEnum;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultGeneratedPass {

    public static String generatePassword(int length){
        if (length < 6){
          throw new PasswordLengthException(ErrorMessageEnum.INVALID_PASSWORD_LENGTH.getMessage());
        }
        final String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        return IntStream.range(0, length)
                .map(i -> random.nextInt(text.length() - 1))
                .mapToObj(randomIndex -> String.valueOf(text.charAt(randomIndex)))
                .collect(Collectors.joining());
    }

    public static String generateCompanyUsername(String companyName) {
        return String.join("", "admin", companyName);
    }
}
