package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Calificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz CalificacionRepository proporciona métodos para realizar operaciones de acceso a datos relacionadas con las calificaciones en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {

}
