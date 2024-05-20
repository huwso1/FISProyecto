package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
}
