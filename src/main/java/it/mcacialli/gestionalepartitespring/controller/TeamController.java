package it.mcacialli.gestionalepartitespring.controller;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TeamRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamResponse;

import it.mcacialli.gestionalepartitespring.model.Team;
import it.mcacialli.gestionalepartitespring.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/team"))

public class TeamController {
    @Autowired
    TeamService teamService;

    //CREA NUOVO TEAM

    @PostMapping
    public TeamResponse create(@RequestBody TeamRequest team) {
        return new TeamResponse(teamService.creaTeam(team));
    }

    @GetMapping
    public List<Team> getAll() {
        return teamService.getAll();
    }


    //CERCA UTENTE PER USERNAME
    @GetMapping("/nome:{nomeTeam}")
    public ResponseEntity<TeamResponse> getByUsername(@PathVariable String nomeTeam) {
        try {
            TeamResponse teamResponse = teamService.getByNomeTeam(nomeTeam);

            return new ResponseEntity<>(teamResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
