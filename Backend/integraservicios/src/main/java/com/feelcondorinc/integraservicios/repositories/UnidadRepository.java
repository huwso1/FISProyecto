package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Unidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends CrudRepository<Unidad, Long> {
}
