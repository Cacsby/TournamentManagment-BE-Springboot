package it.mcacialli.gestionalepartitespring.controller.dto.response;

import it.mcacialli.gestionalepartitespring.model.Utente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteResponse {
    private String nomeUtente;
    private String password;
    private String ruolo;


    public UtenteResponse(Utente utente) {

        nomeUtente = utente.getNomeUtente();
        password = utente.getPassword();
        ruolo= utente.getIdRuolo().getNomeRuolo();
       ;

    }

}
