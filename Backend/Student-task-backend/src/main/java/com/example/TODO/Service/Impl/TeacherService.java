package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.TeacherDTO;
import com.example.TODO.Entity.StudentEntity;
import com.example.TODO.Entity.TeacherEntity;
import com.example.TODO.Repo.TeacherRepo;
import com.example.TODO.Service.TeacherMPL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService implements TeacherMPL {
    @Autowired
    private TeacherRepo teacherRepo;

    public List<TeacherEntity> getAllTeachers(){
        List<TeacherEntity> teachers = teacherRepo.findAll();
        if(teachers.isEmpty()){
            log.warn("No Teachers Found");
            return new ArrayList<>();
        }
        log.debug("All Teachers Load Successfully");
        return teachers;
    }

    @Override
    public HttpStatus createTeacher(TeacherDTO teacher) {
        if(teacherRepo.findByEmail(teacher.getEmail()) != null){
            log.debug("Teacher Already Exist");
            return HttpStatus.CONFLICT;
        }
        TeacherEntity newTeacher = new TeacherEntity();
        newTeacher.setFirstName(teacher.getFirstName());
        newTeacher.setLastName(teacher.getLastName());
        newTeacher.setEmail(teacher.getEmail());
        newTeacher.setPassword(teacher.getPassword());
        newTeacher.setPhoneNumber(teacher.getPhoneNumber());
        teacherRepo.save(newTeacher);
        log.debug("Teacher Created Successfully");
        return HttpStatus.CREATED;
    }

    @Override
    public HttpStatus deleteTeacher(Long id) {
        Optional<TeacherEntity> teacher = teacherRepo.findById(id);
        if(teacher.isEmpty()){
            log.warn("Teacher Not Found With This Id : " + id);
            return HttpStatus.NOT_FOUND;
        }
        teacherRepo.delete(teacher.get());
        log.debug("Teacher " + teacher.get().getFirstName() + " " + teacher.get().getLastName() + " Deleted");
        return HttpStatus.OK;
    }

}