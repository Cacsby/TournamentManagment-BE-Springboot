package it.mcacialli.gestionalepartitespring.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImpostaRisultatoMatchRequest extends MatchRequest{

    private int golCasa;
    private int golOspite;
}
