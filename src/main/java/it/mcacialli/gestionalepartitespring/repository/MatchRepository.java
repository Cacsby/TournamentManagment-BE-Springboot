package it.mcacialli.gestionalepartitespring.repository;

import it.mcacialli.gestionalepartitespring.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface MatchRepository extends CrudRepository<Match,Integer> {

    @Query(value= "select * from match m where m.id_team_casa =?1 and m.id_team_ospite =?2 and m.id_torneo =?3 and m.data_match =?4", nativeQuery = true )
    Match trovaMatchPerImpostareRisultato(Integer idTeamCasa, Integer idTeamOspite, Integer idTorneo, LocalDate dataInizio);
}
