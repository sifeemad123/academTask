package com.example.TODO.Service;

import com.example.TODO.DTO.TeamDTO.TeamRequest;
import com.example.TODO.DTO.TeamDTO.TeamResponse;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface TeamService {

    List<TeamResponse> getTeams();

    HttpStatus addTeam(TeamRequest team);

    HttpStatus deleteTeam(Long id);

    HttpStatus updateTeam(Long id, TeamRequest team);
}
