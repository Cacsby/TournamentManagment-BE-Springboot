package it.mcacialli.gestionalepartitespring.repository;

import it.mcacialli.gestionalepartitespring.model.Campo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CampoRepository extends CrudRepository<Campo, Integer> {
    Campo findByNomeCampo(String nomeCampo);
    List<Campo> findAll();


}
