package com.example.eTaskify_ver1.controller;

import com.example.eTaskify_ver1.model.dto.UserDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddUserDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateUserDto;
import com.example.eTaskify_ver1.service.serviceInterface.UserServiceInt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserServiceInt userServiceInt;

    @GetMapping("/find/id/{id}")
    public UserDto findById(@PathVariable("id") long id){
        return userServiceInt.findById(id);
    }

    @GetMapping("/find-all/admins")
    public List<UserDto> findAllAdmins(){
        return userServiceInt.findAllAdmins();
    }

    @GetMapping("/find-all/users")
    public List<UserDto> findAllUsers(){
        return userServiceInt.findAllUsers();
    }

    @GetMapping("/find/email/{email}")
    public UserDto findByEmail(@PathVariable("email") String email){
        return userServiceInt.findByEmail(email);
    }

    @GetMapping("/find/name/{name}")
    public UserDto findByName(@PathVariable("name") String name){
        return userServiceInt.findByName(name);
    }

    @PostMapping("/add/{id}")
    public UserDto addUSer(@PathVariable("id") long id,
                           @RequestBody AddUserDto addUserDto){
        return userServiceInt.addUser(id, addUserDto);
    }

    @PutMapping("/edit")
    public UserDto updateUser(@RequestBody UpdateUserDto updateUserDto){
        return userServiceInt.updateUser(updateUserDto);
    }
}
