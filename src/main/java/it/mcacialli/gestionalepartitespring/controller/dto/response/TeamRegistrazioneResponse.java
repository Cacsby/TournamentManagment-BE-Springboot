package it.mcacialli.gestionalepartitespring.controller.dto.response;

import it.mcacialli.gestionalepartitespring.model.TeamRegistrazione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRegistrazioneResponse {

    private String nomeUtente;
    private String nomeTeam;


    public TeamRegistrazioneResponse(TeamRegistrazione teamRegistrazione){
        nomeTeam=teamRegistrazione.getTeam().getNomeTeam();
        nomeUtente=teamRegistrazione.getUtente().getNomeUtente();



    }

}
