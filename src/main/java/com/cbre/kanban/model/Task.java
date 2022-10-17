package com.cbre.kanban.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "task")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    UUID id;

    String title;

    String description;

    public static Task dtoToTask(TaskDTO task) {
        return Task.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }
}
