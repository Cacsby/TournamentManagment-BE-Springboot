package it.mcacialli.gestionalepartitespring.repository;

import it.mcacialli.gestionalepartitespring.model.TeamRegistrazione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRegistrazioneRepository extends CrudRepository<TeamRegistrazione, Integer> {

    @Query(value= "select * from team_registrazione tr join team t  on t.id_team  = tr.team_id join utente u on u.id_user =tr.utente_id where t.id_team = ?1", nativeQuery = true )
    List<TeamRegistrazione> searchAllUserInTeam(Integer id);
}
