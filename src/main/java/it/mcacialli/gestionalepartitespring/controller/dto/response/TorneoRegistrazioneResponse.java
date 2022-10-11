package it.mcacialli.gestionalepartitespring.controller.dto.response;

import it.mcacialli.gestionalepartitespring.model.TorneoRegistrazione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TorneoRegistrazioneResponse {

    private String nomeTorneo;
    private String nomeTeam;


    public TorneoRegistrazioneResponse(TorneoRegistrazione torneoRegistrazione){
     nomeTorneo=torneoRegistrazione.getTorneo().getNomeTorneo();
     nomeTeam=torneoRegistrazione.getTeam().getNomeTeam();


    }

}
