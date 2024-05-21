package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
//    @Query()
//    public List<Reserva> findAllByUnidad(int idUnidad);
//
//    @Query()
//    public List<Reserva> findAllByRecurso(int idRecurso);
}
