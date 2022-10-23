package com.example.eTaskify_ver1.mapper;

import com.example.eTaskify_ver1.dao.entity.RoleEntity;
import com.example.eTaskify_ver1.model.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mappings({
            @Mapping(source = "roleName", target = "roleName"),

    })
    RoleDto entityToDto(RoleEntity roleEntity);

    @Mappings({
            @Mapping(source = "roleName", target = "roleName"),

    })
    RoleEntity dtoToEntity(RoleDto roleDto);
}
