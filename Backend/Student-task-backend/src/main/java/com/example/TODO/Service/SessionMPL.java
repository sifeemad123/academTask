package com.example.TODO.Service;

import com.example.TODO.DTO.DepartmentDTO;
import com.example.TODO.DTO.SessionsDTO;
import com.example.TODO.Entity.DepartmentEntity;
import com.example.TODO.Entity.SessionsEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface SessionMPL {
    List<SessionsEntity> getAllSessions();

    HttpStatus createSession(SessionsDTO session);

    HttpStatus deleteSession(Long id);
}
