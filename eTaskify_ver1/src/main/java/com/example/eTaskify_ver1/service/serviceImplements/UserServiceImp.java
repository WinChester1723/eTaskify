package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.dao.repository.RoleRepository;
import com.example.eTaskify_ver1.dao.repository.UserRepository;
import com.example.eTaskify_ver1.model.dto.UserDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddUserDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateUserDto;
import com.example.eTaskify_ver1.service.CustomUserDetails;
import com.example.eTaskify_ver1.service.serviceInterface.UserServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserServiceInt {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException("No user found with the given email: " + email);
        }
        return new CustomUserDetails(userEntity);
    }

    @Override
    public UserDto findById(long id) {
        return null;
    }

    @Override
    public List<UserDto> findAllUsers() {
        return null;
    }

    @Override
    public UserDto findByEmail(String email) {
        return null;
    }

    @Override
    public UserDto findByName(String name) {
        return null;
    }

    @Override
    public UserDto addUser(long id, AddUserDto addUserDto) {
        return null;
    }

    @Override
    public UserDto updateUser(UpdateUserDto updateUserDto) {
        return null;
    }
}
