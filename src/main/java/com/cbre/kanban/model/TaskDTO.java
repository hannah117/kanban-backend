package com.cbre.kanban.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public class TaskDTO {
    UUID id;

    String title;

    String description;

    public static TaskDTO taskToDto(Task task) {
        return TaskDTO.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }
}
