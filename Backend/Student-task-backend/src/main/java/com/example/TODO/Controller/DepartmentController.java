package com.example.TODO.Controller;

import com.example.TODO.DTO.DepartmentDTO;
import com.example.TODO.DTO.SessionsDTO;
import com.example.TODO.Entity.DepartmentEntity;
import com.example.TODO.Service.Impl.DepartmentService;
import com.example.TODO.Service.Impl.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/Department")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentEntity> getAll(){
        log.debug("Request to Retrieve All Teachers");
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public HttpStatus createDepartment(@RequestBody DepartmentDTO department){
        log.debug("Request to Create Teacher");
        return departmentService.createDepartment(department);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDepartment(@PathVariable Long id){
        log.debug("Request to Delete Department With ID : " + id);
        return departmentService.deleteDepartment(id);
    }
}
