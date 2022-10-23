package com.example.eTaskify_ver1.mapper;

import com.example.eTaskify_ver1.dao.entity.OrganizationEntity;
import com.example.eTaskify_ver1.dao.entity.RoleEntity;
import com.example.eTaskify_ver1.model.dto.OrganizationDto;
import com.example.eTaskify_ver1.model.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {
    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),

    })
    OrganizationDto entityToDto(OrganizationEntity organizationEntity);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),

    })
    OrganizationEntity dtoToEntity(OrganizationDto organizationDto);

}
