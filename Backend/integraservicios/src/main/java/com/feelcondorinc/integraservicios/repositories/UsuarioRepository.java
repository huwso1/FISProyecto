package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz UsuarioRepository proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades Usuario en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

}
