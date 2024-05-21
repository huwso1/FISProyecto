package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Horario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Long> {
}
