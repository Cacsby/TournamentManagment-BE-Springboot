package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.controller.dto.request.ImpostaRisultatoMatchRequest;
import it.mcacialli.gestionalepartitespring.controller.dto.response.MatchResponse;
import it.mcacialli.gestionalepartitespring.model.Team;
import it.mcacialli.gestionalepartitespring.repository.TeamRepository;
import it.mcacialli.gestionalepartitespring.repository.TorneoRepository;
import it.mcacialli.gestionalepartitespring.controller.dto.request.MatchRequest;
import it.mcacialli.gestionalepartitespring.model.Match;
import it.mcacialli.gestionalepartitespring.model.Torneo;
import it.mcacialli.gestionalepartitespring.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TorneoRepository torneoRepository;
    @Autowired
    TeamService teamService;

    //CREA MATCH
    public MatchResponse creaMatch(MatchRequest request) {
        Match newMatch = new Match();
        Team teamCasa = teamRepository.findByNomeTeam(request.getTeamCasa());
        Team teamOspite = teamRepository.findByNomeTeam(request.getTeamOspite());
        Torneo torneo = torneoRepository.findByNomeTorneo(request.getNomeTorneo());
        newMatch.setTeamCasa(teamCasa);
        newMatch.setGolCasa(-1);
        newMatch.setTeamOspite(teamOspite);
        newMatch.setGolOspite(-1);
        newMatch.setTorneo(torneo);
        newMatch.setDataMatch(request.getLocalDate());

        return new MatchResponse(matchRepository.save(newMatch));
    }

    //IMPOSTA RISULTATO

    public MatchResponse impostaRisultatiMatch(ImpostaRisultatoMatchRequest request) {
        Team teamCasa = teamRepository.findByNomeTeam(request.getTeamCasa());
        Team teamOspite = teamRepository.findByNomeTeam(request.getTeamOspite());
        Torneo torneo = torneoRepository.findByNomeTorneo(request.getNomeTorneo());
        Match matchDaModificare = matchRepository.trovaMatchPerImpostareRisultato(teamCasa.getIdTeam(), teamOspite.getIdTeam(), torneo.getIdTorneo(), request.getLocalDate());
        matchDaModificare.setGolCasa(request.getGolCasa());
        matchDaModificare.setGolOspite(request.getGolOspite());

        teamService.updateStats(request.getTeamCasa(),request.getTeamOspite(),request.getGolCasa(),request.getGolOspite());

        return new MatchResponse(matchRepository.save(matchDaModificare));
    }
}
