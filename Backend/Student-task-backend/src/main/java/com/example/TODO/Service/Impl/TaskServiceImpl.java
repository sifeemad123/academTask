package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.TaksDTO.TaskRequest;
import com.example.TODO.DTO.TaksDTO.TaskResponse;
import com.example.TODO.Entity.TaskEntity;
import com.example.TODO.Repo.TaskRepo;
import com.example.TODO.Service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public HttpStatus addTask(Map<String, TaskRequest> task) {

        if (task == null || task.isEmpty()) {
            log.error("Add task request null or empty");
            return HttpStatus.BAD_REQUEST;
        }

        try {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTask(task);
            taskRepo.save(taskEntity);
            log.info("Add task request");
            return HttpStatus.CREATED;

        } catch (Exception ex) {
            log.error("Failed to create task", ex);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public HttpStatus updateTask(Long id, Map<String, TaskRequest> task) {

        if (task == null || task.isEmpty()) {
            log.error("Update task request null or empty");
            return HttpStatus.BAD_REQUEST;
        }

        Optional<TaskEntity> optionalTask = taskRepo.findById(id);

        if (optionalTask.isEmpty()) {
            log.error("Update task request id not found");
            return HttpStatus.NOT_FOUND;
        }

        try {
            TaskEntity taskEntity = optionalTask.get();
            taskEntity.setTask(task);

            taskRepo.save(taskEntity);
            log.info("Update task request");
            return HttpStatus.OK;

        } catch (Exception ex) {
            log.error("Failed to update task with id {}", id, ex);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public HttpStatus deleteTask(Long id) {

        if (!taskRepo.existsById(id)) {
            log.error("Delete task request id not found");
            return HttpStatus.NOT_FOUND;
        }

        try {
            log.info("Delete task request");
            taskRepo.deleteById(id);
            return HttpStatus.NO_CONTENT;

        } catch (Exception ex) {
            log.error("Failed to delete task with id {}", id, ex);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        log.info("Get all tasks");
        List<TaskEntity> tasks = taskRepo.findAll();

        List<TaskResponse> taskResponses = new ArrayList<>();

        for (TaskEntity taskEntity : tasks) {
            log.info("Get task with id {}", taskEntity.getId());
            TaskResponse response = new TaskResponse();

            response.setId(taskEntity.getId());
            response.setTask(taskEntity.getTask());
            log.info("Get task with id {}", taskEntity.getId());
            taskResponses.add(response);
        }
        log.info("Get all tasks");
        return taskResponses;
    }
}