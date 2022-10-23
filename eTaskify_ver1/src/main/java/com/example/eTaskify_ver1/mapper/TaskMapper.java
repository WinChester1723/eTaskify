package com.example.eTaskify_ver1.mapper;

import com.example.eTaskify_ver1.dao.entity.TaskEntity;
import com.example.eTaskify_ver1.model.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mappings({
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "statusEnum", target = "statusEnum"),

    })
    TaskDto entityToDto(TaskEntity taskEntity);

    @Mappings({
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "statusEnum", target = "statusEnum"),

    })
    TaskEntity dtoToEntity(TaskDto taskDto);
}
