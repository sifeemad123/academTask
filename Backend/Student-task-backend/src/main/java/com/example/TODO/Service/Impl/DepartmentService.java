package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.DepartmentDTO;
import com.example.TODO.DTO.TeacherDTO;
import com.example.TODO.Entity.DepartmentEntity;
import com.example.TODO.Entity.TeacherEntity;
import com.example.TODO.Repo.DepartmentRepo;
import com.example.TODO.Service.DepartmentMPL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService implements DepartmentMPL {
    private final DepartmentRepo departmentRepo;

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        List<DepartmentEntity> departments = departmentRepo.findAll();
        if(departments.isEmpty()){
            log.debug("No Teachers Found");
            return new ArrayList<>();
        }
        log.debug("Retrieves All Teachers Successfully");
        return departments;
    }

    @Override
    public HttpStatus createDepartment(DepartmentDTO department) {
        if(departmentRepo.findByTitle(department.getTitle()) != null){
            log.debug("This Department Already Created");
            return HttpStatus.CONFLICT;
        }
        DepartmentEntity newDepartment = new DepartmentEntity();
        newDepartment.setTitle(department.getTitle());
        newDepartment.setDescription(department.getDescription());
        newDepartment.setTeams(department.getTeams());
        newDepartment.setTeacher(department.getTeachers());
        departmentRepo.save(newDepartment);
        return HttpStatus.CREATED;
    }

    @Override
    public HttpStatus deleteDepartment(Long id) {
        Optional<DepartmentEntity> department = departmentRepo.findById(id);
        if(department.isEmpty()){
            log.debug("Department Not Found With Id : " + id);
            return HttpStatus.NOT_FOUND;
        }
        departmentRepo.delete(department.get());
        return HttpStatus.OK;
    }
}
