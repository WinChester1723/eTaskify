package com.example.eTaskify_ver1.service.serviceInterface;

import com.example.eTaskify_ver1.dao.entity.UserEntity;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddUserDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateUserDto;
import com.example.eTaskify_ver1.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServiceInt extends UserDetailsService {
    UserDto findById(long id);
    List<UserDto> findAllUsers();
    List<UserDto> findAllAdmins();
    UserDto findByEmail(String email);
    UserDto findByName(String name);
    UserDto addUser(long id, AddUserDto addUserDto);
    UserDto updateUser(UpdateUserDto updateUserDto);
}
