package it.mcacialli.gestionalepartitespring.controller;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TorneoRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TorneoResponse;
import it.mcacialli.gestionalepartitespring.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/torneo"))

public class TorneoController {

    @Autowired
    TorneoService torneoService;

    //CREAZIONE NUOVO TORNEO
    @PostMapping
    public ResponseEntity<TorneoResponse> create(@RequestBody TorneoRequest torneo) {
        TorneoResponse torneoResponse= torneoService.creaTorneo(torneo);
        return new ResponseEntity<>(torneoResponse, HttpStatus.OK);
    }


}
