package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.dao.repository.RoleRepository;
import com.example.eTaskify_ver1.dao.repository.UserRepository;
import com.example.eTaskify_ver1.service.CustomUserDetails;
import com.example.eTaskify_ver1.service.serviceInterface.UserServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
