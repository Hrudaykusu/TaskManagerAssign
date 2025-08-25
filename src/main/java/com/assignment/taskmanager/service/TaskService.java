package com.assignment.taskmanager.service;

import com.assignment.taskmanager.dto.TaskRequestDto;
import com.assignment.taskmanager.dto.TaskResponseDto;
import com.assignment.taskmanager.entity.Task;
import com.assignment.taskmanager.exception.TaskNotFoundException;
import com.assignment.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public TaskResponseDto createTask(TaskRequestDto dto) {
        Task task = new Task(
                dto.title(),
                dto.description(),
                dto.status(),
                dto.priority(),
                dto.dueDate()
        );
        return mapToResponse(repository.save(task));
    }

    public List<TaskResponseDto> getAllTasks() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TaskResponseDto getTaskById(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        return mapToResponse(task);
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto dto) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());
        task.setDueDate(dto.dueDate());
        return mapToResponse(repository.save(task));
    }

    public void deleteTask(Long id) {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private TaskResponseDto mapToResponse(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getDueDate()
        );
    }
}
