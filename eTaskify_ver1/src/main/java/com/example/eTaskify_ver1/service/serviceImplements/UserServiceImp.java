package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.dao.entity.UserEntity;
import com.example.eTaskify_ver1.dao.repository.UserRepository;
import com.example.eTaskify_ver1.exceptions.UserException;
import com.example.eTaskify_ver1.mapper.OrganizationMapper;
import com.example.eTaskify_ver1.mapper.UserMapper;
import com.example.eTaskify_ver1.model.dto.UserDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddUserDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.UpdateUserDto;
import com.example.eTaskify_ver1.model.enums.ErrorMessageEnum;
import com.example.eTaskify_ver1.model.enums.RoleEnum;
import com.example.eTaskify_ver1.service.CustomUserDetails;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import com.example.eTaskify_ver1.service.serviceInterface.UserServiceInt;
import com.example.eTaskify_ver1.utils.DefaultGeneratedPass;
import com.example.eTaskify_ver1.utils.ValidUtilInt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserServiceInt {

    private final UserRepository userRepository;
    private final OrganizationServiceInt organizationServiceInt;
    private final ValidUtilInt validUtilInt;

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
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ErrorMessageEnum.INVALID_USER.getMessage(id)));
        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    public List<UserDto> findAllAdmins() {
        return userRepository.findByRoles(RoleEnum.ADMIN)
                .stream()
                .map(userEntity -> UserMapper.INSTANCE.entityToDto(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findByRoles(RoleEnum.USER)
                .stream()
                .map(userEntity -> UserMapper.INSTANCE.entityToDto(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findByEmail(String email) {
        var userEntity = userRepository.findByEmail(email);
        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    public UserDto findByName(String name) {
        var userEntity = userRepository.findByName(name);
        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    @Transactional
    public UserDto addUser(long id, AddUserDto addUserDto) {
        var organization = organizationServiceInt.findOrgId(id);

        var userEntity = UserEntity.builder()
                .name(addUserDto.getName())
                .surname(addUserDto.getSurname())
                .email(addUserDto.getEmail())
                .password(DefaultGeneratedPass.generatePassword(8))
                .organizationEntity(OrganizationMapper.INSTANCE.dtoToEntity(organization))
                .taskEntities(new ArrayList<>())
                .build();
        organization.getUserEntityList().add(userEntity);
        userRepository.save(userEntity);

        return UserMapper.INSTANCE.entityToDto(userEntity);
    }

    @Override
    @Transactional
    public UserDto updateUser(UpdateUserDto updateUserDto) {
        var userDto = findById(updateUserDto.getId());
        validUtilInt.validatePassword(userDto.getPassword());
        userDto.setName(updateUserDto.getName());
        userDto.setSurname(updateUserDto.getSurname());
        userDto.setEmail(updateUserDto.getEmail());
        userDto.setPassword(updateUserDto.getPassword());

        var userEntity =  UserMapper.INSTANCE.dtoToEntity(userDto);
        userRepository.save(userEntity);

        return UserMapper.INSTANCE.entityToDto(userEntity);
    }


}
