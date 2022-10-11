package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TorneoRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TorneoResponse;
import it.mcacialli.gestionalepartitespring.model.Campo;
import it.mcacialli.gestionalepartitespring.repository.CampoRepository;
import it.mcacialli.gestionalepartitespring.repository.TorneoRepository;
import it.mcacialli.gestionalepartitespring.model.Torneo;
import it.mcacialli.gestionalepartitespring.model.Utente;
import it.mcacialli.gestionalepartitespring.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TorneoService {

    @Autowired
    TorneoRepository torneoRepository;
    @Autowired
    CampoRepository campoRepository;
    @Autowired
    UtenteRepository utenteRepository;


    //CREAZIONE NUOVO TORNEO SE ADMIN
    public TorneoResponse creaTorneo(TorneoRequest request) {
        Torneo torneo = new Torneo();
        Optional<Utente> singleUtente = utenteRepository.findById(request.getIdUtente());

        if (singleUtente.isPresent()) {
            torneo.setNomeTorneo(request.getNomeTorneo());
            torneo.setDataInizio(request.getDataInizio());
            torneo.setNMaxSquadre(request.getNMaxSquadre());
            Campo campo = campoRepository.findByNomeCampo(request.getNomeCampo());
            torneo.setIdCampo(campo);
        }
            return new TorneoResponse(torneoRepository.save(torneo));
    }
}
