package com.example.eTaskify_ver1.model.dto;

import com.example.eTaskify_ver1.model.enums.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private TaskStatusEnum statusEnum;

}
