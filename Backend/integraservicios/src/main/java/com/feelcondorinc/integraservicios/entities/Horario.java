package com.feelcondorinc.integraservicios.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

/**
 * La clase Horario representa una entidad en la base de datos para almacenar información sobre horarios.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Horarios")
public class Horario {

    /**
     * Identificador único del horario.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorario")
    private Long idHorario;

    /**
     * Hora de inicio del horario.
     */
    @Column(name = "horaInicial")
    private int horaInicial;

    /**
     * Minuto de inicio del horario.
     */
    @Column(name = "minutoInicial")
    private int minutoInicial;

    /**
     * Hora de finalización del horario.
     */
    @Column(name = "horaFinal")
    private int horaFinal;

    /**
     * Minuto de finalización del horario.
     */
    @Column(name = "minutoFinal")
    private int minutoFinal;

    /**
     * Día de la semana al que corresponde el horario.
     */
    @Column(name = "diaSemana")
    private String diaSemana;

    /**
     * Relación muchos a uno con la entidad HorarioDisponible.
     * El nombre de la columna que almacena esta relación es 'idHorarioDisponible'.
     * Este campo no puede ser nulo.
     * La anotación @JsonIgnore evita que este campo se serialice en la respuesta JSON.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idHorarioDisponible", nullable = false)
    private HorarioDisponible horarioDisponible;
}
