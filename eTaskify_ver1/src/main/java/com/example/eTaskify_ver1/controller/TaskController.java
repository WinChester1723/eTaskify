package com.example.eTaskify_ver1.controller;

import com.example.eTaskify_ver1.model.dto.TaskDto;
import com.example.eTaskify_ver1.model.dto.dto_add_upd.AddTaskDto;
import com.example.eTaskify_ver1.service.serviceInterface.TaskServiceInt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("task")
public class TaskController {
    private final TaskServiceInt taskServiceInt;

    @GetMapping("/find/id/{id}")
    public TaskDto findTaskById(@PathVariable("id") long id) {
        return taskServiceInt.findTaskById(id);
    }

    @GetMapping("/all-task")
    public List<TaskDto> findAllTasks() {
        return taskServiceInt.findAllTasks();
    }

    @PostMapping("/add-task/{id}")
    public TaskDto addTask(@PathVariable("id") long id,
                           @RequestBody AddTaskDto addTaskDto) {
        return taskServiceInt.addTask(id, addTaskDto);
    }

    @GetMapping("/find/title/{title}")
    public List<TaskDto> findByTitle(@PathVariable("title") String title){
        return taskServiceInt.findByTitle(title);
    }
}
