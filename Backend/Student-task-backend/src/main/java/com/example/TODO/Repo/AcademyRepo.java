package com.example.TODO.Repo;

import com.example.TODO.Entity.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepo extends JpaRepository<AcademyEntity, Long> {
}
