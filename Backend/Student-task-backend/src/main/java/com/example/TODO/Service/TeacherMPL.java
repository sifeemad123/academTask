package com.example.TODO.Service;

import com.example.TODO.DTO.TeacherDTO;
import com.example.TODO.Entity.TeacherEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface TeacherMPL {
    List<TeacherEntity> getAllTeachers();

    HttpStatus createTeacher(TeacherDTO teacher);

    HttpStatus deleteTeacher(Long id);

}
