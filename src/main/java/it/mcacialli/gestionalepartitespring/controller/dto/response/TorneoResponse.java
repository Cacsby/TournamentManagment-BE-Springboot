package it.mcacialli.gestionalepartitespring.controller.dto.response;

import it.mcacialli.gestionalepartitespring.model.Torneo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TorneoResponse {
    private int nMaxSquadre;
    private String nomeCampo;
    private LocalDate dataInizio;
    private String nomeTorneo;

    private List<TeamResponse> listaTeamRegistrati = new ArrayList<>();


    public TorneoResponse(Torneo torneo) {

        nomeTorneo = torneo.getNomeTorneo();
        nMaxSquadre = torneo.getNMaxSquadre();
        nomeCampo = torneo.getIdCampo().getNomeCampo();
        dataInizio= torneo.getDataInizio();

    }

    public TorneoResponse(ResponseEntity<Torneo> creaTorneo) {

    }
}
