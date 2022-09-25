package com.cbre.kanban.controller;


import com.cbre.kanban.model.TaskDTO;
import com.cbre.kanban.repository.TaskRepo;
import com.cbre.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


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
    public void createTask(@RequestBody TaskDTO task){
        taskService.createTask(task);
    }
}
