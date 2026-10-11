package com.example.TODO.Repo;

import com.example.TODO.Entity.SessionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<SessionsEntity, Long> {
}
