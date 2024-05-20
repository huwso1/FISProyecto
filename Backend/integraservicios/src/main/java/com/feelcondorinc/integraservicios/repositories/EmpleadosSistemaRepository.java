package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.EmpleadosSistema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosSistemaRepository extends CrudRepository<EmpleadosSistema, Integer> {
}
