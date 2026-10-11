package com.example.TODO.Repo;

import com.example.TODO.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByTitle(String title);
}
