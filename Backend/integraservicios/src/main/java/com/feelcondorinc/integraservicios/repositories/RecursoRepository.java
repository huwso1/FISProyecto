package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Recurso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends CrudRepository<Recurso, Integer> {
}