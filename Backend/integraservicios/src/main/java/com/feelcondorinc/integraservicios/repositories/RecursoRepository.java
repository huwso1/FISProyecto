package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Unidad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RecursoRepository extends CrudRepository<Recurso, Long> {

    public List<Recurso> findByIdUnidad(Unidad idUnidad);
}
