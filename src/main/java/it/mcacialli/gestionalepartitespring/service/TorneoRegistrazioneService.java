package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TorneoRegistrazioneRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamResponse;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TorneoRegistrazioneResponse;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TorneoResponse;
import it.mcacialli.gestionalepartitespring.model.Team;
import it.mcacialli.gestionalepartitespring.model.Torneo;
import it.mcacialli.gestionalepartitespring.model.TorneoRegistrazione;
import it.mcacialli.gestionalepartitespring.repository.TeamRegistrazioneRepository;
import it.mcacialli.gestionalepartitespring.repository.TeamRepository;
import it.mcacialli.gestionalepartitespring.repository.TorneoRegistrazioneRepository;
import it.mcacialli.gestionalepartitespring.repository.TorneoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TorneoRegistrazioneService {
    @Autowired
    TorneoRegistrazioneRepository torneoRegistrazioneRepository;
    @Autowired
    TeamRegistrazioneRepository teamRegistrazioneRepository;
    @Autowired
    TorneoRepository torneoRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamRegistrazioneService teamRegistrazioneService;

    //CREAZIONE NUOVA REGISTRAZIONE
    public TorneoRegistrazioneResponse creaTeamRegistrazione(TorneoRegistrazioneRequest request) {
        TorneoRegistrazione torneoRegistrazione = new TorneoRegistrazione();
        Torneo torneo = torneoRepository.findbyId(request.getIdTorneo());
        Team team = teamRepository.findByNomeTeam(request.getNomeTeam());
        torneoRegistrazione.setTorneo(torneo);
        torneoRegistrazione.setTeam(team);
        if (torneo.getNMaxSquadre() > torneo.getPartecipazione().size()) {

            return new TorneoRegistrazioneResponse(torneoRegistrazioneRepository.save(torneoRegistrazione));
        }
        //GESTIRE MEGLIO
        else return null;

    }

    //CERCA UTENTI APPARTENENTI A UN TEAM
    public TorneoResponse getTeamPerTorneo(Integer id) {
        List<TorneoRegistrazione> listaRegistrazioniTorneo = torneoRegistrazioneRepository.searchAllTeamInTorneo(id);
        TorneoResponse torneoResponse = new TorneoResponse();
        torneoResponse.setNomeTorneo(listaRegistrazioniTorneo.get(0).getTorneo().getNomeTorneo());
        torneoResponse.setDataInizio(listaRegistrazioniTorneo.get(0).getTorneo().getDataInizio());
        torneoResponse.setNMaxSquadre(listaRegistrazioniTorneo.get(0).getTorneo().getNMaxSquadre());
        torneoResponse.setNomeCampo(listaRegistrazioniTorneo.get(0).getTorneo().getIdCampo().getNomeCampo());


        List<TeamResponse> listaTeamInTorneo = new ArrayList<>();
        int numeroTeamTotali = 0;

        for (TorneoRegistrazione l : listaRegistrazioniTorneo) {
            TeamResponse teamResponse = teamRegistrazioneService.getUtentiPerTeam(l.getTeam().getIdTeam());

            listaTeamInTorneo.add(teamResponse);
        }
        torneoResponse.setListaTeamRegistrati(listaTeamInTorneo);
        return torneoResponse;
    }
}


