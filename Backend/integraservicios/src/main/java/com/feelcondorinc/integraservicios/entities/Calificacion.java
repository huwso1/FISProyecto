package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * La clase Calificacion representa una entidad en la base de datos para almacenar información sobre las calificaciones.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Calificaciones")
public class Calificacion {

    /**
     * Identificador único de la calificación.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalificacion")
    private Long idCalificacion;

    /**
     * Calificación de cumplimiento de horario.
     */
    @Column(name = "cumplimientoHorario")
    private int cumplimientoHorario;

    /**
     * Calificación de la calidad del recurso.
     */
    @Column(name = "calidadRecurso")
    private int calidadRecurso;

    /**
     * Calificación del estado del recurso.
     */
    @Column(name = "estadoRecurso")
    private int estadoRecurso;

    /**
     * Calificación del trato personal.
     */
    @Column(name = "tratoPersonal")
    private int tratoPersonal;

    /**
     * Observaciones adicionales sobre la calificación.
     */
    @Column(name = "observaciones")
    private String observaciones;

    /**
     * Relación muchos a uno con la entidad EmpleadosSistema.
     * El nombre de la columna que almacena esta relación es 'idEmpleadoCalificado'.
     * Este campo no puede ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "idEmpleadoCalificado", nullable = false)
    private EmpleadosSistema idEmpleado;

    /**
     * Relación uno a uno con la entidad Reserva.
     * El nombre de la columna que almacena esta relación es 'idReservaCalificada'.
     * Este campo no puede ser nulo.
     */
    @OneToOne
    @JoinColumn(name = "idReservaCalificada", nullable = false)
    private Reserva reserva;

    /**
     * Relación muchos a uno con la entidad Usuario.
     * El nombre de la columna que almacena esta relación es 'idAfiliadoCalificador'.
     * Este campo no puede ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "idAfiliadoCalificador", nullable = false)
    private Usuario idUsuario;
}
