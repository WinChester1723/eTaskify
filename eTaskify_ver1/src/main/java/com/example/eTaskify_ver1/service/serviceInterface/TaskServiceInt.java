package com.example.eTaskify_ver1.service.serviceInterface;

import com.example.eTaskify_ver1.model.dto.TaskDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddTaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskServiceInt{
    TaskDto findTaskById(long id);
    List<TaskDto> findAllTasks();
    TaskDto addTask(long id, AddTaskDto addTaskDto);
    List<TaskDto> findByTitle(String title);
}
