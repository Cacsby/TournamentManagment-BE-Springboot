package it.mcacialli.gestionalepartitespring.controller;



import it.mcacialli.gestionalepartitespring.service.UtenteService;
import it.mcacialli.gestionalepartitespring.controller.dto.request.UtenteRequest;

import it.mcacialli.gestionalepartitespring.controller.dto.response.UtenteResponse;
import it.mcacialli.gestionalepartitespring.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/utente"))

public class UtenteController {
    @Autowired
    UtenteService utenteService;

    //LISTA TUTTI UTENTI
    @GetMapping
    public List<Utente> findAll(){
        return utenteService.findAll();
    }

    //CREAZIONE NUOVO UTENTE
    @PostMapping
    public ResponseEntity<UtenteResponse> create(@RequestBody UtenteRequest utente) {
        UtenteResponse utenteResponse=utenteService.createUser(utente);
        return new ResponseEntity<>(utenteResponse, HttpStatus.OK);
    }

    //CERCA UTENTE PER ID
    @GetMapping("/id:{idUtente}")
    public Optional<Utente> getById(@PathVariable Integer idUtente) {
        return  utenteService.getById(idUtente);
    }

    //CERCA UTENTE PER USERNAME
    @GetMapping("/nome:{nomeUtente}")
    public ResponseEntity<UtenteResponse> getByUsername(@PathVariable String nomeUtente) {
        UtenteResponse utenteResponse= utenteService.getByUsername(nomeUtente);
        return new ResponseEntity<>(utenteResponse,HttpStatus.OK);
    }
}
