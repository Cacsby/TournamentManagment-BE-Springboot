package it.mcacialli.gestionalepartitespring.controller.dto.response;


import it.mcacialli.gestionalepartitespring.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponse {


    private String nomeTeam;
    private String nomeCapoSquadra;
    private int numeroGiocatori;
    private List<UtenteResponse> listaUtentiRegistrati = new ArrayList<>();
    private int numVittorie;
    private int numPareggi;
    private int numSconfitte;

    private int totalScore;

    public TeamResponse(Team team) {

        nomeTeam = team.getNomeTeam();
        nomeCapoSquadra = team.getUtenteCaposquadra().getNomeUtente();
        numVittorie=team.getNVittorie();
        numPareggi=team.getNPareggi();
        numSconfitte=team.getNSconfitte();
    }
}



