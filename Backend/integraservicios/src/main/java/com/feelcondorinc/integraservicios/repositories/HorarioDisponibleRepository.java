package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.HorarioDisponible;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz HorarioDisponibleRepository proporciona métodos para realizar operaciones de acceso a datos relacionadas con los horarios disponibles en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface HorarioDisponibleRepository extends CrudRepository<HorarioDisponible, Long> {
}
