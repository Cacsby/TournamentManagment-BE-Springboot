package it.mcacialli.gestionalepartitespring.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatchRequest {
    private String teamCasa;
    private String teamOspite;
    private LocalDate localDate;
    private String nomeTorneo;

}
