package com.example.TODO.Controller;

import com.example.TODO.DTO.TaksDTO.TaskRequest;
import com.example.TODO.DTO.TaksDTO.TaskResponse;
import com.example.TODO.Service.Impl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/API/V1/Tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping
    public ResponseEntity<Void> addTask(
            @RequestBody Map<String, TaskRequest> taskRequest) {
        log.debug("Request to save Task : {}", taskRequest);
        HttpStatus status = taskService.addTask(taskRequest);
    log.debug("status : {}", status);
        return ResponseEntity.status(status).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(
            @PathVariable Long id,
            @RequestBody Map<String, TaskRequest> taskRequest) {
    log.debug("Request to save Task : {}", taskRequest);
        HttpStatus status = taskService.updateTask(id, taskRequest);
log.debug("status : {}", status);
        return ResponseEntity.status(status).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
log.debug("Request to delete Task : {}", id);
        HttpStatus status = taskService.deleteTask(id);
log.debug("status : {}", status);
        return ResponseEntity.status(status).build();
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
log.debug("Request to get all Tasks");
        return ResponseEntity.ok(taskService.getAllTasks());
    }
}