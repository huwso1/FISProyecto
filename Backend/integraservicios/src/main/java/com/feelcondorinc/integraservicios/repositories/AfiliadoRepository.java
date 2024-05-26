package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Afiliado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoRepository extends CrudRepository<Afiliado, Long> {
}
