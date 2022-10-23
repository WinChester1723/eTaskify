package com.example.eTaskify_ver1.model.enums;

import com.example.eTaskify_ver1.exceptions.TaskStatusEnumException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TaskStatusEnum {
    NEW(0),
    IN_PROCESS(1),
    COMPLETED(2),
    CANCELED(3);

    private final int id;

    public static TaskStatusEnum of(int id){
        return Stream.of(TaskStatusEnum.values())
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskStatusEnumException
                        (ErrorMessageEnum.INVALID_TASK_STATUS_ENUM.getMessage()));
    }
}
