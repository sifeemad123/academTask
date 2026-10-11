package com.example.TODO.Repo;

import com.example.TODO.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherEntity, Long> {
    TeacherEntity findByEmail(String email);
}
