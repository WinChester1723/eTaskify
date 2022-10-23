package com.example.eTaskify_ver1.service.serviceInterface;

import com.example.eTaskify_ver1.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServiceInt extends UserDetailsService {
    UserDto findById(long id);
    List<UserDto> findAllUsers();

}
