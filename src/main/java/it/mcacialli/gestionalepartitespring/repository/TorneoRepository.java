package it.mcacialli.gestionalepartitespring.repository;

import it.mcacialli.gestionalepartitespring.model.Torneo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TorneoRepository extends CrudRepository<Torneo, Integer> {

    @Override
    Optional<Torneo> findById(Integer integer);

    @Query(value= "SELECT * FROM torneo t WHERE t.id_torneo = ?1", nativeQuery = true )
    Torneo findbyId(Integer id);

    Torneo findByNomeTorneo(String nomeTorneo);
}
