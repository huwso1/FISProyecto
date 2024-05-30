package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Horario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz HorarioRepository proporciona métodos para realizar operaciones de acceso a datos relacionadas con los horarios en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface HorarioRepository extends CrudRepository<Horario, Long> {
    
}
