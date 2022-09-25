package com.cbre.kanban.service;

import com.cbre.kanban.model.Task;
import com.cbre.kanban.model.TaskDTO;
import com.cbre.kanban.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    public TaskDTO createTask(TaskDTO task){
        Task newTask = Task.dtoToTask(task);
        return TaskDTO.taskToDto(taskRepo.save(newTask));
    }
}
