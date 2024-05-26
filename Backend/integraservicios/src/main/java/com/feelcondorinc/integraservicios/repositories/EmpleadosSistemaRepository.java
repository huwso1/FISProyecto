package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.EmpleadosSistema;
import com.feelcondorinc.integraservicios.entities.Unidad;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmpleadosSistemaRepository extends CrudRepository<EmpleadosSistema,Long> {

    public List<EmpleadosSistema> findByIdUnidad(Unidad idUnidad);

}
