package it.mcacialli.gestionalepartitespring.repository;

import it.mcacialli.gestionalepartitespring.model.TorneoRegistrazione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TorneoRegistrazioneRepository extends CrudRepository<TorneoRegistrazione, Integer> {

    @Query(value= "select * from torneo_registrazione tr join team t  on t.id_team  = tr.team_id join torneo t2 on t2.id_torneo  =tr.torneo_id where t2.id_torneo =?1", nativeQuery = true )
    List<TorneoRegistrazione> searchAllTeamInTorneo(Integer id);
}