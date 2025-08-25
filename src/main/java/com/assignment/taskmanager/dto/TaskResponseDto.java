package com.assignment.taskmanager.dto;

import com.assignment.taskmanager.enums.Priority;
import com.assignment.taskmanager.enums.TaskStatus;

import java.time.LocalDate;

public record TaskResponseDto(
        Long id,
        String title,
        String description,
        TaskStatus status,
        Priority priority,
        LocalDate dueDate
) {}
