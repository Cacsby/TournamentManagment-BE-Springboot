package it.mcacialli.gestionalepartitespring.repository;

import it.mcacialli.gestionalepartitespring.model.Ruolo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RuoloRepository extends CrudRepository<Ruolo, Integer> {

    List<Ruolo> findAll();

    Ruolo findByNomeRuolo(String nome);
    }
