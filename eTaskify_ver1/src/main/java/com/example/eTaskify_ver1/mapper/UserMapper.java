package com.example.eTaskify_ver1.mapper;

import com.example.eTaskify_ver1.dao.entity.UserEntity;
import com.example.eTaskify_ver1.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),

    })
    UserDto entityToDto(UserEntity userEntity);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),

    })
    UserEntity dtoToEntity(UserDto userDto);
}
