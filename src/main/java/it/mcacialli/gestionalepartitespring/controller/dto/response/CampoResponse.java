package it.mcacialli.gestionalepartitespring.controller.dto.response;

import it.mcacialli.gestionalepartitespring.model.Campo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampoResponse {

    private String nomeCampo;
    private String indirizzoCampo;

    public CampoResponse(Campo campo){
        nomeCampo=campo.getNomeCampo();
        indirizzoCampo=campo.getIndirizzoCampo();


    }
}
