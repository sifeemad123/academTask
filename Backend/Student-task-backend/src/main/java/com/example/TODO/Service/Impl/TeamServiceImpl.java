package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.TeamDTO.TeamRequest;
import com.example.TODO.DTO.TeamDTO.TeamResponse;
import com.example.TODO.Entity.TeamEntity;
import com.example.TODO.Repo.StudentRepo;
import com.example.TODO.Repo.TeamRepo;
import com.example.TODO.Service.TeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepo teamRepo;
    private final StudentRepo studentRepo;

    @Override
    public List<TeamResponse> getTeams() {

        List<TeamEntity> teams = teamRepo.findAll();

        if (teams.isEmpty()) {
            log.info("No teams found");
            return new ArrayList<>();
        }

        List<TeamResponse> teamResponses = new ArrayList<>();
        for (TeamEntity team : teams) {
            log.info("Team ID: " + team.getId());
            TeamResponse teamResponse = new TeamResponse();
            teamResponse.setName(team.getName());
            teamResponses.add(teamResponse);
            log.info("Team Name: " + team.getName());
        }
        log.info("Team Responses: " + teamResponses);
        return teamResponses;


    }

    @Override
    @Transactional
    public HttpStatus addTeam(TeamRequest team) {
        try {
            log.info("Adding team: " + team.getName());
            TeamEntity teamEntity = new TeamEntity();
            teamEntity.setName(team.getName());
            teamRepo.save(teamEntity);
            log.info("Team ID: " + teamEntity.getId());
            return HttpStatus.OK;
        } catch (Exception e) {
            log.error(e.getMessage());
            return HttpStatus.BAD_REQUEST;
        }
    }

    @Override
    public HttpStatus deleteTeam(Long id) {
        if (teamRepo.existsById(id)) {
            try {
                log.info("Deleting team: " + id);
                teamRepo.deleteById(id);
                return HttpStatus.OK;
            } catch (Exception e) {
                log.error(e.getMessage());
                return HttpStatus.BAD_REQUEST;
            }
        }
        log.error("no team found");
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public HttpStatus updateTeam(Long id, TeamRequest team) {

        if (teamRepo.existsById(id)) {
            try {
                log.info("Updating team: " + id);
                TeamEntity teamEntity = teamRepo.findById(id).get();
                teamEntity.setName(team.getName());
                teamRepo.save(teamEntity);
                log.info("Team ID: " + teamEntity.getId());
                return HttpStatus.OK;
            } catch (Exception e) {
                log.error(e.getMessage());
                return HttpStatus.BAD_REQUEST;
            }
        }
        log.error("no team found");
        return HttpStatus.NOT_FOUND;
    }
}
