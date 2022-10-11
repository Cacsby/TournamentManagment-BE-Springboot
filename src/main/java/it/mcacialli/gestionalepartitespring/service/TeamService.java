package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.controller.dto.request.TeamRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamResponse;
import it.mcacialli.gestionalepartitespring.repository.TeamRepository;
import it.mcacialli.gestionalepartitespring.controller.dto.request.TeamRegistrazioneRequest;
import it.mcacialli.gestionalepartitespring.model.Team;
import it.mcacialli.gestionalepartitespring.model.Utente;
import it.mcacialli.gestionalepartitespring.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    TeamRegistrazioneService teamRegistrazioneService;

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    //CREAZIONE NUOVO UTENTE
    public Team creaTeam(TeamRequest request) {
        Team team = new Team();
        team.setNomeTeam(request.getNomeTeam());
        team.setNPareggi(0);
        team.setNSconfitte(0);
        team.setNVittorie(0);
        Utente utente = utenteRepository.findbyId(request.getIdCapoSquadra());
        team.setUtenteCaposquadra(utente);
         team= teamRepository.save(team);
        //creo una nuova request team registrazione, che prende in input i valori della request, ossia caposquadra e nome, cosi
        //da passarli al metodo creaTeamRegistrazione, così alla creazione di una squadra il caposquadra viene inserito automaticamente
        TeamRegistrazioneRequest teamRegistrazioneRequest=new TeamRegistrazioneRequest(request.getIdCapoSquadra(), request.getNomeTeam());
        teamRegistrazioneService.creaTeamRegistrazione(teamRegistrazioneRequest);
        return team;
    }

    //CERCA TEAM PER NOME
    public TeamResponse getByNomeTeam(String nomeTeam) {

        return new TeamResponse(teamRepository.findByNomeTeam(nomeTeam));
    }

    //UPDATE STATS VITTORIE SCONFITTE
    public void updateStats(String teamC, String teamO, int golCasa, int golOspite) {
        Team teamCasa= teamRepository.findByNomeTeam(teamC);
        Team teamOspite= teamRepository.findByNomeTeam(teamO);
        if (golCasa > golOspite) {
            teamCasa.setNVittorie(teamCasa.getNVittorie() + 1);
            teamOspite.setNSconfitte(teamOspite.getNSconfitte() + 1);
        }
        if (golCasa < golOspite) {
            teamCasa.setNSconfitte(teamCasa.getNSconfitte() + 1);
            teamOspite.setNVittorie(teamOspite.getNVittorie() + 1);
        } if(golCasa==golOspite) {
            teamCasa.setNPareggi(teamCasa.getNPareggi() + 1);
            teamOspite.setNPareggi(teamOspite.getNPareggi() + 1);
        }

      teamRepository.save(teamCasa);
        teamRepository.save(teamOspite);

    }





}
