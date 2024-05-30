package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Unidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz UnidadRepository proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades Unidad en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface UnidadRepository extends CrudRepository<Unidad, Long> {

}
