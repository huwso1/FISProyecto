package com.feelcondorinc.integraservicios.repositories;

import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.entities.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


/**
 * La interfaz ReservaRepository proporciona métodos para realizar operaciones de acceso a datos relacionadas con las reservas en la base de datos.
 * Esta interfaz extiende CrudRepository, que proporciona métodos genéricos para operaciones CRUD.
 */
@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {

    /**
     * Recupera todas las reservas asociadas a una unidad específica.
     *
     * @param idUnidad el identificador de la unidad.
     * @return una colección de objetos Reserva asociados a la unidad especificada.
     */
    @Query(value = "SELECT re.* FROM unidades u, recursos r, reservas re WHERE re.id_Recurso = r.id_Recurso AND r.id_Unidad = u.id_Unidad AND u.id_Unidad = ?1", nativeQuery = true)
    public Collection<Reserva> cantidadReservas(Long idUnidad);

    /**
     * Recupera todas las reservas asociadas a un recurso específico.
     *
     * @param idRecurso el identificador del recurso.
     * @return una colección de objetos Reserva asociados al recurso especificado.
     */
    @Query(value = "SELECT re.* FROM recursos r, reservas re WHERE r.id_Recurso = re.id_Recurso AND re.id_Recurso = ?1", nativeQuery = true)
    public Collection<Reserva> cantidadReservasRecurso(Long idRecurso);

    /**
     * Recupera todas las reservas activas asociadas a un recurso específico.
     *
     * @param idRecurso el identificador del recurso.
     * @return una colección de objetos Reserva que están activas y asociadas al recurso especificado.
     */
    @Query(value = "SELECT re.* FROM recursos r, reservas re WHERE r.idRecurso = re.id_Recurso AND re.id_Recurso = ?1 AND re.estado = 'PENDIENTE'", nativeQuery = true)
    public Collection<Reserva> reservasActivasRecurso(Long idRecurso);

    /**
     * Recupera todas las reservas activas asociadas a una unidad específica.
     *
     * @param idUnidad el identificador de la unidad.
     * @return una colección de objetos Reserva que están activas y asociadas a la unidad especificada.
     */
    @Query(value = "SELECT re.* FROM unidades u, recursos r, reservas re WHERE re.id_Recurso = r.id_Recurso AND r.id_Unidad = u.id_Unidad AND u.id_Unidad = ?1 AND re.estado = 'PENDIENTE'", nativeQuery = true)
    public Collection<Reserva> reservasActivasUnidad(Long idUnidad);

    /**
     * Recupera todas las reservas activas asociadas a un recurso específico en una fecha determinada.
     *
     * @param fecha     la fecha en formato 'DD-MM-YYYY'.
     * @param idRecurso el identificador del recurso.
     * @return una colección de objetos Reserva que están activas, asociadas al recurso especificado y en la fecha proporcionada.
     */
    @Query(value = "SELECT re.* FROM recursos r, reservas re WHERE r.id_Recurso = re.id_Recurso AND re.id_Recurso = ?2 AND re.estado = 'PENDIENTE' AND re.fecha = TO_DATE(?1, 'DD-MM-YYYY')", nativeQuery = true)
    public Collection<Reserva> reservasActivasPorFechaRecurso(String fecha, Long idRecurso);
    
    public List<Reserva> findByIdUsuario(Usuario idUsuario);

    @Query(value="SELECT re.* from recursos r, reservas re where r.id_recurso=re.id_recurso and r.id_unidad=?1 AND re.estado != 'CANCELADA'",nativeQuery=true)
    public List<Reserva>  reservasActivasPorUnidad(Long idUnidad);

    @Query(value="select * from reservas",nativeQuery=true)
    public List<Reserva>  findreservas();

}
