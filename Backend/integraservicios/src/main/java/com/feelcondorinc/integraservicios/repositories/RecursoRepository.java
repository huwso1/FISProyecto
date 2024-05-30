package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Unidad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La interfaz RecursoRepository proporciona métodos para realizar operaciones de acceso a datos relacionadas con los recursos en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface RecursoRepository extends CrudRepository<Recurso, Long> {

    /**
     * Recupera todos los recursos asociados a una unidad específica.
     *
     * @param idUnidad La unidad asociada a los recursos.
     * @return Una lista de recursos asociados a la unidad especificada.
     */
    public List<Recurso> findByIdUnidad(Unidad idUnidad);
}
