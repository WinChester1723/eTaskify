package com.example.eTaskify_ver1.controller;

import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddUserDto;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import com.example.eTaskify_ver1.service.serviceInterface.UserServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//after using web pages this file for testing work it or not
@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class UserRegistrationController {
    private final UserServiceInt userServiceInt;

    @GetMapping("/show")
    public String showRegPage() {
        return "registration";
    }

    @PostMapping("/register/add/{id}")
    public String userRegister(@PathVariable("id") long id,
            @ModelAttribute("user") AddUserDto addUserDto) {
            userServiceInt.addUser(id, addUserDto);
        return "redirect:/registration?success";
    }
}
