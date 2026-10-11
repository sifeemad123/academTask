package com.example.TODO.DTO.TaksDTO;

import com.example.TODO.Entity.Enum.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    private String taskName;

    private String taskDescription;

    private List<Long> students;

    private Long teacher;

    private TaskType taskType;
}