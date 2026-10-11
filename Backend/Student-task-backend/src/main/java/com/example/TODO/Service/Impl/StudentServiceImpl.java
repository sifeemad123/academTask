package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.StudentDTO.StudentsREQ;
import com.example.TODO.Entity.StudentEntity;
import com.example.TODO.Entity.TeamEntity;
import com.example.TODO.Repo.StudentRepo;
import com.example.TODO.Repo.TeamRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements com.example.TODO.Service.StudentService {

    private final StudentRepo studentRepo;
    private final TeamRepo teamRepo;

    @Override
    public List<StudentEntity> getAllStudent() {
        log.debug("Receive Request for getAllStudent on Service ");
        List<StudentEntity> students = studentRepo.findAll();
        if (students.isEmpty()) {
            log.warn("Students not found");
            return new ArrayList<>();

        }
        log.info("all Students is returned on service ");
        return students;

    }

    @Override
    public HttpStatus createStudent(StudentsREQ student) {
        log.info("Receive Request for create Student on Service " + student.toString());
        if (studentRepo.findByEmail(student.getEmail()) != null) {
            log.warn("Student already exists");
            return HttpStatus.CONFLICT;

        }

        StudentEntity Student = new StudentEntity();
        log.debug("{} " + student.getGrade().toString());
        Student.setFirstName(student.getFirstName());
        Student.setLastName(student.getLastName());
        Student.setEmail(student.getEmail());
        Student.setPassword(student.getPassword());
        Student.setGrade(student.getGrade());



        studentRepo.save(Student);
        log.info("Student has been created");
        return HttpStatus.OK;

    }

    @Override
    public HttpStatus deleteStudent(Long id) {
        log.info("Receive Request for delete Student on Service " + id);
        if (studentRepo.findById(id).isPresent()) {
            studentRepo.deleteById(id);
            log.info("Student has been deleted");
            return HttpStatus.OK;
        }
        log.warn("Student not found");
        return HttpStatus.NOT_FOUND;

    }


    @Override
    public ResponseEntity<String> assignStudentToTeam(Long studentId, Long teamId) {

        Optional<StudentEntity> studentOptional = studentRepo.findById(studentId);
        Optional<TeamEntity> teamOptional = teamRepo.findById(teamId);

        if (studentOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found");
        }

        if (teamOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Team not found");
        }

        StudentEntity student = studentOptional.get();
        TeamEntity team = teamOptional.get();

        student.setTeam(team);
        studentRepo.save(student);

        return ResponseEntity.ok("Student assigned to team successfully");
    }


}
