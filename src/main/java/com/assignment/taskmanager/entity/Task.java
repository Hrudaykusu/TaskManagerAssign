package com.assignment.taskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    private String description;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private com.assignment.taskmanager.enums.TaskStatus status;

    @NotNull(message = "Priority is required")
    @Enumerated(EnumType.STRING)
    private com.assignment.taskmanager.enums.Priority priority;

    private LocalDate dueDate;

    // ✅ Constructors
    public Task() {
    }

    public Task(String title, String description,
                com.assignment.taskmanager.enums.TaskStatus status,
                com.assignment.taskmanager.enums.Priority priority,
                LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public com.assignment.taskmanager.enums.TaskStatus getStatus() { return status; }
    public void setStatus(com.assignment.taskmanager.enums.TaskStatus status) { this.status = status; }

    public com.assignment.taskmanager.enums.Priority getPriority() { return priority; }
    public void setPriority(com.assignment.taskmanager.enums.Priority priority) { this.priority = priority; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
