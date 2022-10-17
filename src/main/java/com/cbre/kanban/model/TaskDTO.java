package com.cbre.kanban.model;

import lombok.*;

import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {

    UUID id;

    String title;

    String description;

    public static TaskDTO taskToDto(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }
}
