package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TeamRegistrazioneRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamRegistrazioneResponse;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamResponse;
import it.mcacialli.gestionalepartitespring.model.Team;
import it.mcacialli.gestionalepartitespring.model.TeamRegistrazione;
import it.mcacialli.gestionalepartitespring.repository.TeamRegistrazioneRepository;
import it.mcacialli.gestionalepartitespring.repository.TeamRepository;
import it.mcacialli.gestionalepartitespring.controller.dto.response.UtenteResponse;
import it.mcacialli.gestionalepartitespring.model.Utente;
import it.mcacialli.gestionalepartitespring.repository.UtenteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TeamRegistrazioneService {
    @Autowired
    TeamRegistrazioneRepository teamRegistrazioneRepository;
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    TeamRepository teamRepository;

    //CREAZIONE NUOVA REGISTRAZIONE
    public TeamRegistrazioneResponse creaTeamRegistrazione(TeamRegistrazioneRequest request) {
        TeamRegistrazione teamRegistrazione = new TeamRegistrazione();
        Utente utente = utenteRepository.findbyId(request.getIdUtente());
        Team team = teamRepository.findByNomeTeam(request.getNomeTeam());
        teamRegistrazione.setTeam(team);
        teamRegistrazione.setUtente(utente);

        return new TeamRegistrazioneResponse(teamRegistrazioneRepository.save(teamRegistrazione));
    }

    //CERCA UTENTI APPARTENENTI A UN TEAM
    public TeamResponse getUtentiPerTeam(Integer id) {
        List<TeamRegistrazione> listaRegistrazioniTeam = teamRegistrazioneRepository.searchAllUserInTeam(id);

        TeamResponse teamResponse = new TeamResponse();
        Optional<Team> team= teamRepository.findById(id);
        teamResponse.setNomeTeam(team.get().getNomeTeam());
        teamResponse.setNomeCapoSquadra(team.get().getUtenteCaposquadra().getNomeUtente());
        teamResponse.setNumVittorie(team.get().getNVittorie());
        teamResponse.setNumPareggi(team.get().getNPareggi());
        teamResponse.setNumSconfitte(team.get().getNSconfitte());

        List<UtenteResponse> listaUtentiInTeam = new ArrayList<>();
        int numeroGiocatori = 0;
        for (TeamRegistrazione l : listaRegistrazioniTeam) {
            UtenteResponse utenteResponse = new UtenteResponse();
            utenteResponse.setNomeUtente(l.getUtente().getNomeUtente());
            utenteResponse.setRuolo(l.getUtente().getIdRuolo().getNomeRuolo());
            utenteResponse.setPassword(l.getUtente().getPassword());
            numeroGiocatori++;
            listaUtentiInTeam.add(utenteResponse);
        }
        teamResponse.setNumeroGiocatori(numeroGiocatori);
        teamResponse.setListaUtentiRegistrati(listaUtentiInTeam);
        return teamResponse;
    }

    }

