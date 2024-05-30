package com.feelcondorinc.integraservicios.entities;

import com.feelcondorinc.integraservicios.entities.models.EstadoReserva;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * La clase Reserva representa una entidad en la base de datos para almacenar información sobre reservas.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reservas")
public class Reserva {

    /**
     * Identificador único de la reserva.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @Column(name = "idReserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    /**
     * Hora de inicio de la reserva.
     */
    @Column(name = "horaInicial")
    private int horaInicial;

    /**
     * Minuto de inicio de la reserva.
     */
    @Column(name = "minutoInicial")
    private int minutoInicial;

    /**
     * Hora de finalización de la reserva.
     */
    @Column(name = "horaFinal")
    private int horaFinal;

    /**
     * Minuto de finalización de la reserva.
     */
    @Column(name = "minutoFinal")
    private int minutoFinal;

    /**
     * Fecha de la reserva.
     * El tipo temporal es DATE.
     */
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    /**
     * Estado de la reserva, almacenado como una cadena de texto.
     * Utiliza un enum para representar los estados posibles.
     */
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;

    /**
     * Observaciones adicionales sobre la reserva.
     */
    @Column(name = "observaciones")
    private String observaciones;

    /**
     * Relación muchos a uno con la entidad Recurso.
     * El nombre de la columna que almacena esta relación es 'idRecurso'.
     * No puede ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "idRecurso", nullable = false)
    private Recurso idRecurso;

    /**
     * Relación muchos a uno con la entidad Usuario.
     * El nombre de la columna que almacena esta relación es 'idUsuario'.
     * No puede ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;
}
