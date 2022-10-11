package it.mcacialli.gestionalepartitespring.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TorneoRequest {

    private String nomeTorneo;
    private int nMaxSquadre;
    private LocalDate dataInizio;
    private String nomeCampo;
    private int idUtente;

}
