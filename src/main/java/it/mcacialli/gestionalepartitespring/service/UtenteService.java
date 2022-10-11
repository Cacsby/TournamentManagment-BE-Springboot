package it.mcacialli.gestionalepartitespring.service;


import it.mcacialli.gestionalepartitespring.controller.dto.request.UtenteRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.UtenteResponse;
import it.mcacialli.gestionalepartitespring.model.Ruolo;
import it.mcacialli.gestionalepartitespring.model.Utente;
import it.mcacialli.gestionalepartitespring.repository.RuoloRepository;
import it.mcacialli.gestionalepartitespring.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RuoloRepository ruoloRepository;

    //TORNA TUTTI GLI UTENTI
    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    //CREAZIONE NUOVO UTENTE
    public UtenteResponse createUser(UtenteRequest request) {
        Utente utente = new Utente();
        Ruolo ruolo= ruoloRepository.findByNomeRuolo(request.getRuolo());
        utente.setNomeUtente(request.getNomeUtente());
        utente.setPassword(encoder.encode(request.getPassword()));
       utente.setIdRuolo(ruolo);
        return new UtenteResponse(utenteRepository.save(utente));
    }

    //CERCA UTENTE PER USERNAME
    public Optional<Utente> getById(Integer idUtente) {
        return utenteRepository.findById(idUtente);
    }

    //CERCA UTENTE PER USERNAME
    public UtenteResponse getByUsername(String nomeUtente) {
        return new UtenteResponse(utenteRepository.findByNomeUtente(nomeUtente));
    }

}
