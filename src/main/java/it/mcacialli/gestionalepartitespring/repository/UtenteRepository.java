package it.mcacialli.gestionalepartitespring.repository;

import it.mcacialli.gestionalepartitespring.model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends CrudRepository<Utente, Integer> {

    List<Utente> findAll();
    Utente findByNomeUtente(String nomeUtente);

    @Override
    Optional<Utente> findById(Integer integer);

    @Query(value= "SELECT u.* FROM utente u WHERE u.id_user = ?1", nativeQuery = true )
    Utente findbyId(Integer id);
}
