package com.example.TODO.Controller;

import com.example.TODO.DTO.SessionsDTO;
import com.example.TODO.Entity.SessionsEntity;
import com.example.TODO.Service.Impl.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/Sessions")
@Slf4j
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    public List<SessionsEntity> getAll(){
        log.debug("Request to Retrieve All Sessions");
        return sessionService.getAllSessions();
    }

    @PostMapping
    public HttpStatus createSession(@RequestBody SessionsDTO sessions){
        log.debug("Request to Create Session");
        return sessionService.createSession(sessions);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSession(@PathVariable Long id){
        log.debug("Request to Delete Session With ID : " + id);
        return sessionService.deleteSession(id);
    }
}
