package com.example.eTaskify_ver1.service.serviceImplements;

import com.example.eTaskify_ver1.model.dto.TaskDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddTaskDto;
import com.example.eTaskify_ver1.service.serviceInterface.TaskServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TaskServiceImp implements TaskServiceInt {
    @Override
    public TaskDto findTaskById(long id) {
        return null;
    }

    @Override
    public List<TaskDto> findAllTasks() {
        return null;
    }

    @Override
    public TaskDto addTask(long id, AddTaskDto addTaskDto) {
        return null;
    }

    @Override
    public Optional<TaskDto> findByTitle(String title) {
        return Optional.empty();
    }
}
