package com.example.TODO.DTO;

import com.example.TODO.Entity.TeacherEntity;
import com.example.TODO.Entity.TeamEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class DepartmentDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private List<TeamEntity> teams;
    @NotBlank
    private List<TeacherEntity> teachers;
}
