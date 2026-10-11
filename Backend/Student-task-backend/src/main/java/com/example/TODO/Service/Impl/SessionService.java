package com.example.TODO.Service.Impl;
import com.example.TODO.DTO.SessionsDTO;
import com.example.TODO.Entity.SessionsEntity;
import com.example.TODO.Repo.SessionRepo;
import com.example.TODO.Service.SessionMPL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService implements SessionMPL {

    private final SessionRepo sessionRepo;

    @Override
    public List<SessionsEntity> getAllSessions() {
        List<SessionsEntity> sessions = sessionRepo.findAll();
        if(sessions.isEmpty()){
            log.debug("No Sessions Found");
            return new ArrayList<>();
        }
        log.debug("All Sessions Retrieves Successfully");
        return sessions;
    }

    @Override
    public HttpStatus createSession(SessionsDTO session) {
        try{
            log.debug("Creating Session...");
            SessionsEntity newSession = new SessionsEntity();
            newSession.setStartDate(session.getStartDate());
            newSession.setEndDate(session.getEndDate());
            newSession.setStatus(session.getStatus());
            newSession.setTeams(session.getTeams());
            sessionRepo.save(newSession);
            log.debug("Creating Session Successfully");
            return HttpStatus.CREATED;
        }catch (Exception e){
            log.error(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public HttpStatus deleteSession(Long id) {
        Optional<SessionsEntity> session = sessionRepo.findById(id);
        if(session.isEmpty()){
            log.debug("Session Not Fount To Delete it With ID : " + id);
            return HttpStatus.NOT_FOUND;
        }
        sessionRepo.delete(session.get());
        return HttpStatus.OK;
    }
}
