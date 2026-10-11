package com.example.TODO.Controller;

import com.example.TODO.DTO.StudentDTO.StudentsREQ;
import com.example.TODO.Entity.StudentEntity;
import com.example.TODO.Service.Impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/Students")
@Slf4j
@RequiredArgsConstructor
public class StudentController {


    private final StudentServiceImpl studentServiceImpl;

    @GetMapping()
    public List<StudentEntity> getAllStudents() {
        log.debug("Receive Request for return all Students on Controller ");
        List<StudentEntity> students = studentServiceImpl.getAllStudent();
        log.info("Return all Students on Controller ");
        log.info(students.toString());
        return students;

    }


    @PostMapping()
    public HttpStatus createStudent(@RequestBody StudentsREQ student) {
        log.info("Receive Request for create Student on Controller " + student.toString());
        log.debug("{}" + student.getGrade().toString());
        HttpStatus student1 = studentServiceImpl.createStudent(student);
        log.info("Create Student on Controller " + student1.toString());
        return student1;
    }


    @DeleteMapping("/{Id}")
    public HttpStatus deleteStudent(@PathVariable Long Id) {
        log.info("Receive Request for delete Student on Controller " + Id);
        HttpStatus student1 = studentServiceImpl.deleteStudent(Id);
        log.info("Delete Student on Controller " + student1.toString());
        return student1;

    }


    @PutMapping("/{studentId}/team/{teamId}")
    public ResponseEntity<String> assignStudentToTeam(
            @PathVariable Long studentId,
            @PathVariable Long teamId) {

        return studentServiceImpl.assignStudentToTeam(studentId, teamId);
    }


}
