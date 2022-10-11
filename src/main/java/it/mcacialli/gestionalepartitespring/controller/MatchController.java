package it.mcacialli.gestionalepartitespring.controller;

import it.mcacialli.gestionalepartitespring.controller.dto.request.ImpostaRisultatoMatchRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.request.MatchRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.MatchResponse;
import it.mcacialli.gestionalepartitespring.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/match"))
public class MatchController {

    @Autowired
    MatchService matchService;

    //CREA MATCH
    @PostMapping
    public ResponseEntity<MatchResponse> creaMatch(@RequestBody MatchRequest match) {

            MatchResponse matchResponse = matchService.creaMatch(match);
            return new ResponseEntity<>(matchResponse, HttpStatus.OK);
    }

    @PutMapping
    @PostMapping
    public ResponseEntity<MatchResponse> impostaRisultatoMatch(@RequestBody ImpostaRisultatoMatchRequest match) {
        MatchResponse matchResponse = matchService.impostaRisultatiMatch(match);
        return new ResponseEntity<>(matchResponse, HttpStatus.OK);
    }
}
