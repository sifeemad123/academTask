package com.example.TODO.Service;

import com.example.TODO.DTO.StudentDTO.StudentsREQ;
import com.example.TODO.Entity.StudentEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getAllStudent();

    HttpStatus deleteStudent(Long id);

    HttpStatus createStudent(StudentsREQ student);

    ResponseEntity<String> assignStudentToTeam(Long studentId, Long teamId);
}
