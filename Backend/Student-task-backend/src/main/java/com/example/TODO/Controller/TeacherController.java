package com.example.TODO.Controller;

import com.example.TODO.DTO.TeacherDTO;
import com.example.TODO.Entity.TeacherEntity;
import com.example.TODO.Service.Impl.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/Teacher")
@Slf4j
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherEntity> getAll(){
        log.debug("Request to Retrieve All Teachers");
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public HttpStatus createTeacher(@RequestBody TeacherDTO teacher){
        log.debug("Request to Create Teacher");
        return teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTeacher(@PathVariable Long id){
        log.debug("Request to Delete Teacher With ID : " + id);
        return teacherService.deleteTeacher(id);
    }
}
