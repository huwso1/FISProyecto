package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Reserva;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
//    @Query()
//    public List<Reserva> findAllByUnidad(int idUnidad);
//
//    @Query()
//    public List<Reserva> findAllByRecurso(int idRecurso);
@Query(value="select re.fecha ,re.hora_final ,re.hora_inicial ,re.minuto_final ,re.minuto_inicial ,re.id_Recurso ,re.id_reserva ,re.id_usuario ,re.estado,re.observaciones  from unidades u,recursos r, reservas re where re.id_recurso=r.id_recurso and r.id_unidad=u.id_unidad and u.id_unidad=?1",nativeQuery = true )
    public Collection<Reserva> cantidadReservas(Long idunidad);

@Query(value="select re.fecha ,re.hora_final ,re.hora_inicial ,re.minuto_final ,re.minuto_inicial ,re.id_Recurso ,re.id_reserva ,re.id_usuario ,re.estado,re.observaciones  from recursos r, reservas re where r.id_recurso=re.id_recurso and re.id_recurso=?1 ",nativeQuery = true )
    public Collection<Reserva> cantidadReservasRecurso(Long idrecurso);
    
}
