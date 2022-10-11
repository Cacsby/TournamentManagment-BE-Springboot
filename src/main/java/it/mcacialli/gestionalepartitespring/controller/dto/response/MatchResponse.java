package it.mcacialli.gestionalepartitespring.controller.dto.response;

import it.mcacialli.gestionalepartitespring.model.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponse {

   private String nomeTorneo;

   private LocalDate dataInizio;
    private String teamCasa;
    private int golCasa;
    private String teamOspite;
    private int golOspite;

    public MatchResponse(Match match){
        nomeTorneo=match.getTorneo().getNomeTorneo();
        dataInizio=match.getDataMatch();
        teamCasa=match.getTeamCasa().getNomeTeam();
        golCasa= match.getGolCasa();
        teamOspite=match.getTeamOspite().getNomeTeam();
        golOspite=match.getGolOspite();
    }
}
