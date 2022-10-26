package com.example.eTaskify_ver1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//after using web pages this file for testing work it or not
@Controller
@RequiredArgsConstructor
@RequestMapping("web")
public class WebController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }
}
