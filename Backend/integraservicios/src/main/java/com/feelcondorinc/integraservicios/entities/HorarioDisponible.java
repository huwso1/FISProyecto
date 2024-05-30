package com.feelcondorinc.integraservicios.entities;

import com.feelcondorinc.integraservicios.entities.models.EstadoRecurso;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La clase HorarioDisponible representa una entidad en la base de datos para almacenar información sobre horarios disponibles.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HorariosDisponibles")
public class HorarioDisponible {

    /**
     * Identificador único del horario disponible.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorarioDisponible")
    private Long idHorarioDisponible;

    /**
     * Fecha de inicio del horario disponible.
     * Este campo no puede ser nulo.
     */
    @Column(name = "fechaInicial", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    /**
     * Fecha de finalización del horario disponible.
     */
    @Column(name = "fechaFinal")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    /**
     * Estado del recurso, almacenado como una cadena de texto.
     * Utiliza un enum para representar los estados posibles.
     * Este campo no puede ser nulo.
     */
    @Column(name = "estadoRecurso", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoRecurso estadoRecurso;

    /**
     * Lista de horarios asociados a este horario disponible.
     * La relación es uno a muchos y se mapea por el campo `horarioDisponible` en la entidad `Horario`.
     * Los horarios se cargan de manera perezosa y se eliminan en cascada.
     */
    @OneToMany(mappedBy = "horarioDisponible", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Horario> horarios = new ArrayList<>();
}
