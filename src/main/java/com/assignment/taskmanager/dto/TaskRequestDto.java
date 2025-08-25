package com.assignment.taskmanager.dto;

import com.assignment.taskmanager.enums.Priority;
import com.assignment.taskmanager.enums.TaskStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record TaskRequestDto(
        @NotBlank @Size(min = 3, max = 100) String title,
        @Size(max = 500) String description,
        @NotNull TaskStatus status,
        @NotNull Priority priority,
        @FutureOrPresent LocalDate dueDate
) {}
