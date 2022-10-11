package it.mcacialli.gestionalepartitespring.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRegistrazioneRequest {
    private int idUtente;
    private String nomeTeam;
}
