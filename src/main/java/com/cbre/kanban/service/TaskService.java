package com.cbre.kanban.service;

import com.cbre.kanban.model.Task;
import com.cbre.kanban.model.TaskDTO;
import com.cbre.kanban.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    public void createTask(TaskDTO task){
        Task newTask = Task.dtoToTask(task);
        taskRepo.save(newTask);
    }

    public void deleteTask(UUID id) {
         taskRepo.deleteById(id);
    }

    public TaskDTO findTaskById(UUID id) {
        Optional<Task> task = taskRepo.findById(id);
        if(task.isPresent()){
            return TaskDTO.taskToDto(task.get());
        }
        throw new NoSuchElementException();
    }

    public List<TaskDTO> findAllTasks() {
        return taskRepo.findAll()
                .stream()
                .map(TaskDTO::taskToDto)
                .collect(Collectors.toList());
    }
}
