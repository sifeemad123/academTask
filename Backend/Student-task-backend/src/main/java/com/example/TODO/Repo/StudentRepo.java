package com.example.TODO.Repo;

import com.example.TODO.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByEmail(String email);
}
