package it.mcacialli.gestionalepartitespring.controller;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TorneoRegistrazioneRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TorneoRegistrazioneResponse;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TorneoResponse;
import it.mcacialli.gestionalepartitespring.service.TorneoRegistrazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/registrazioneTorneo"))

public class TorneoRegistrazioneController {

    @Autowired
    TorneoRegistrazioneService torneoRegistrazioneService;

    //CREA NUOVA REGISTRAZIONE AL TORNEO
    @PostMapping
    public ResponseEntity<TorneoRegistrazioneResponse> create(@RequestBody TorneoRegistrazioneRequest registrazione) {
        TorneoRegistrazioneResponse torneoRegistrazioneResponse= torneoRegistrazioneService.creaTeamRegistrazione(registrazione);
        return new ResponseEntity<>(torneoRegistrazioneResponse, HttpStatus.OK);
    }

    //OTTIENI TUTTI I GIOCATORI DI UN TORNEO
    @GetMapping("/{idTorneo}")
    public ResponseEntity<TorneoResponse> cercaTuttiUtentiInTeam(@PathVariable Integer idTorneo){
        TorneoResponse torneoResponse = torneoRegistrazioneService.getTeamPerTorneo(idTorneo);
        return new ResponseEntity<>(torneoResponse, HttpStatus.OK);
    }

}
