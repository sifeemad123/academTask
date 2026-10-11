package com.example.TODO.Service;

import com.example.TODO.DTO.StudentDTO.StudentsREQ;
import com.example.TODO.DTO.TaksDTO.TaskRequest;
import com.example.TODO.DTO.TaksDTO.TaskResponse;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public interface TaskService {

    HttpStatus addTask(Map<String, TaskRequest> task);

    HttpStatus updateTask(Long id , Map<String, TaskRequest> task);

    HttpStatus deleteTask(Long id);

    List<TaskResponse> getAllTasks();

}
