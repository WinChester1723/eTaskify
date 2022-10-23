package com.example.eTaskify_ver1.model.dto.dto_add_upd;

import com.example.eTaskify_ver1.dao.entity.UserEntity;
import com.example.eTaskify_ver1.model.enums.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTaskDto {
    private String title;
    private String description;
    private TaskStatusEnum statusEnum;
    private List<UserEntity> usersList;
}
