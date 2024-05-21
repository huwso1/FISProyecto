package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.HorarioDisponible;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioDisponibleRepository extends CrudRepository<HorarioDisponible, Long> {
}
