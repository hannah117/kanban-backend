package com.cbre.kanban.controller;


import com.cbre.kanban.model.TaskDTO;
import com.cbre.kanban.repository.TaskRepo;
import com.cbre.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@Controller
@RequestMapping(path = "/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepo taskRepo;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void createTask(@RequestBody TaskDTO task) {
        taskService.createTask(task);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") UUID id) {
        taskService.deleteTask(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable("id") UUID id) {
        return taskService.findTaskById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TaskDTO> getAllTask() {
        return taskService.findAllTasks();
    }
}
