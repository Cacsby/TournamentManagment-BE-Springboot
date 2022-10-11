package it.mcacialli.gestionalepartitespring.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TorneoRegistrazioneRequest {
    private int idTorneo;
    private String nomeTeam;
}
