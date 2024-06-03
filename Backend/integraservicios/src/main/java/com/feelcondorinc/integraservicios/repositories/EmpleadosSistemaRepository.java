package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.EmpleadosSistema;
import com.feelcondorinc.integraservicios.entities.Unidad;
import com.feelcondorinc.integraservicios.entities.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * La interfaz EmpleadosSistemaRepository proporciona métodos para realizar operaciones de acceso a datos relacionadas con los empleados del sistema en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface EmpleadosSistemaRepository extends CrudRepository<EmpleadosSistema, Long> {

    /**
     * Recupera todos los empleados del sistema asociados a una unidad específica.
     *
     * @param idUunidad La unidad asociada a los empleados del sistema.
     * @return Una lista de empleados del sistema asociados a la unidad especificada.
     */
    public List<EmpleadosSistema> findByIdUnidad(Unidad idUnidad);
    public Optional<EmpleadosSistema> findByIdUsuario(Usuario idUsuario);
}
