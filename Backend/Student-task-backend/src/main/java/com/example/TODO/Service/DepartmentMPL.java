package com.example.TODO.Service;

import com.example.TODO.DTO.DepartmentDTO;
import com.example.TODO.Entity.DepartmentEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface DepartmentMPL {
    List<DepartmentEntity> getAllDepartments();

    HttpStatus createDepartment(DepartmentDTO department);

    HttpStatus deleteDepartment(Long id);
}
