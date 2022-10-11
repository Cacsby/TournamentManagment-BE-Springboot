package it.mcacialli.gestionalepartitespring.controller;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TeamRegistrazioneRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamRegistrazioneResponse;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamResponse;
import it.mcacialli.gestionalepartitespring.service.TeamRegistrazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/registrazioneTeam"))

public class TeamRegistrazioneController {

    @Autowired
    TeamRegistrazioneService teamRegistrazioneService;


    //CREA NUOVO TEAM
    @PostMapping
    public ResponseEntity<TeamRegistrazioneResponse> create(@RequestBody TeamRegistrazioneRequest registrazione) {
        TeamRegistrazioneResponse teamRegistrazioneResponse= teamRegistrazioneService.creaTeamRegistrazione(registrazione);
        return new ResponseEntity<>(teamRegistrazioneResponse, HttpStatus.OK);
    }

    //OTTIENI TUTTI I GIOCATORI DI UN TEAM
    @GetMapping("/{idTeam}")
    public ResponseEntity<TeamResponse> cercaTuttiUtentiInTeam(@PathVariable Integer idTeam){
        TeamResponse teamResponse= teamRegistrazioneService.getUtentiPerTeam(idTeam);
        return new ResponseEntity<>( teamResponse, HttpStatus.OK);

    }

}
