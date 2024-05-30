package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * La clase EmpleadosSistema representa una entidad en la base de datos para almacenar información sobre los empleados del sistema.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EmpleadosSistema")
public class EmpleadosSistema {

    /**
     * Identificador único del empleado del sistema.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Long idEmpleado;

    /**
     * Correo corporativo del empleado.
     */
    @Column(name = "correoCorporativo")
    private String correoCorporativo;

    /**
     * Relación muchos a uno con la entidad HorarioDisponible.
     * El nombre de la columna que almacena esta relación es 'idHorarioEmpleado'.
     */
    @ManyToOne
    @JoinColumn(name = "idHorarioEmpleado")
    private HorarioDisponible idHorarioDisponible;

    /**
     * Relación muchos a uno con la entidad Unidad.
     * El nombre de la columna que almacena esta relación es 'idUnidadAsocaciada'.
     * Este campo no puede ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "idUnidadAsocaciada", nullable = false)
    private Unidad idUnidad;

    /**
     * Relación uno a uno con la entidad Usuario.
     * El nombre de la columna que almacena esta relación es 'idUsuarioEmpleado'.
     * Este campo no puede ser nulo.
     */
    @OneToOne
    @JoinColumn(name = "idUsuarioEmpleado", nullable = false)
    private Usuario idUsuario;
}
