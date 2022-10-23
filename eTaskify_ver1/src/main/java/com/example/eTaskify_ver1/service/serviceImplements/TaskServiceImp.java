package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.dao.entity.TaskEntity;
import com.example.eTaskify_ver1.dao.repository.TaskRepository;
import com.example.eTaskify_ver1.exceptions.TaskException;
import com.example.eTaskify_ver1.mapper.TaskMapper;
import com.example.eTaskify_ver1.model.dto.TaskDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddTaskDto;
import com.example.eTaskify_ver1.model.enums.ErrorMessageEnum;
import com.example.eTaskify_ver1.model.enums.TaskStatusEnum;
import com.example.eTaskify_ver1.service.serviceInterface.OrganizationServiceInt;
import com.example.eTaskify_ver1.service.serviceInterface.TaskServiceInt;
import com.example.eTaskify_ver1.service.serviceInterface.UserServiceInt;
import com.example.eTaskify_ver1.utils.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImp implements TaskServiceInt {
    private final TaskRepository taskRepository;
    private final OrganizationServiceInt organizationServiceInt;
    private final UserServiceInt userServiceInt;
    private final EmailUtil emailUtil;
    @Override
    public TaskDto findTaskById(long id) {
        var taskEntity = taskRepository.findById(id)
                .orElseThrow(()-> new TaskException(ErrorMessageEnum.INVALID_TASK.getMessage(id)));
        return TaskMapper.INSTANCE.entityToDto(taskEntity);
    }

    @Override
    public List<TaskDto> findAllTasks() {
        return taskRepository.findAll().stream().map(taskEntity -> TaskMapper.INSTANCE.entityToDto(taskEntity))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto addTask(long id, AddTaskDto addTaskDto) {
        organizationServiceInt.findOrgId(id);

        var taskEntity = TaskEntity.builder()
                .title(addTaskDto.getTitle())
                .description(addTaskDto.getDescription())
                .statusEnum(addTaskDto.getStatusEnum())
                .usersList(addTaskDto.getUsersList())
                .build();
        emailUtil.notifyEmployeesByEmail(taskEntity.getId(),taskEntity.getUsersList());
        taskRepository.save(taskEntity);

        return TaskMapper.INSTANCE.entityToDto(taskEntity);
    }

    @Override
    public List<TaskDto> findByTitle(String title) {
        return taskRepository.findByTitle(title).stream()
                .map(taskEntity -> TaskMapper.INSTANCE.entityToDto(taskEntity))
                .collect(Collectors.toList());
    }
}
