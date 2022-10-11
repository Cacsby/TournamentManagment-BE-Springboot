package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.controller.dto.response.TeamResponse;
import it.mcacialli.gestionalepartitespring.model.Team;
import it.mcacialli.gestionalepartitespring.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ClassificaService {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamService teamService;
    @Autowired
    TeamRegistrazioneService teamRegistrazioneService;


    public List<TeamResponse> classificaTotalScore() {
        List<Team> listaTotaliTeam = teamService.getAll();
        List<TeamResponse> listaClassifica = new ArrayList<>();


        for (Team singleTeam : listaTotaliTeam) {
            TeamResponse teamResponse = teamRegistrazioneService.getUtentiPerTeam(singleTeam.getIdTeam());

            teamResponse.setTotalScore(calcolaScore(teamResponse.getNumVittorie(),teamResponse.getNumPareggi()));

            listaClassifica.add(teamResponse);
        }
        List<TeamResponse> listaClassificaOrdinata= listaClassifica.stream()
                .sorted(Comparator.comparing(TeamResponse::getTotalScore).reversed()).toList();

        return  listaClassificaOrdinata;

    }


    private int calcolaScore(Integer numVittorie, Integer numPareggi){
        int ptVittoria=3;
        int ptPareggi=1;
        return (numVittorie*ptVittoria)+(numPareggi*ptPareggi);
    }
}
