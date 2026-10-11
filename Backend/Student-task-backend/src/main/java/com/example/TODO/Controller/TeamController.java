package com.example.TODO.Controller;

import com.example.TODO.DTO.TeamDTO.TeamRequest;
import com.example.TODO.DTO.TeamDTO.TeamResponse;
import com.example.TODO.Service.Impl.TeamServiceImpl;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/API/V1/Team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamServiceImpl teamService;

    //    add
    @PostMapping
    public HttpStatus addTeam(@RequestBody TeamRequest team) {
        log.debug("Request to save Team : {}", team);
        HttpStatus teamCreation = teamService.addTeam(team);
        log.debug("teamCreation : {}", teamCreation);
        return teamCreation;
    }

//    update

    @PutMapping("/{id}")
    public HttpStatus updateTeam(@PathVariable Long id, @RequestBody @NotBlank TeamRequest team) {
        log.debug("Request to update Team : {}", team);
        HttpStatus teamUpdate = teamService.updateTeam(id, team);
        log.debug("teamUpdate : {}", teamUpdate);
        return teamUpdate;
    }

    //    delete
    @DeleteMapping("/{id}")
    public HttpStatus deleteTeam(@PathVariable Long id) {
        log.debug("Request to delete Team : {}", id);
        HttpStatus teamDelete = teamService.deleteTeam(id);
        log.debug("teamDelete : {}", teamDelete);
        return teamDelete;
    }

    //    get
    @GetMapping
    public List<TeamResponse> getTeams() {
        log.debug("Request to get all Teams");
        List<TeamResponse> teamResponse = teamService.getTeams();
        log.debug("teamResponse : {}", teamResponse);
        return teamResponse;
    }

}
