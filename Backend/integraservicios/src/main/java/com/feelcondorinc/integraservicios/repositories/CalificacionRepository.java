package com.feelcondorinc.integraservicios.repositories;


import com.feelcondorinc.integraservicios.entities.Calificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {

}