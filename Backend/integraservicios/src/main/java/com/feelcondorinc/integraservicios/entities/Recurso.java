package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * La clase Recurso representa una entidad en la base de datos para almacenar información sobre recursos.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Recursos")
public class Recurso {

    /**
     * Identificador único del recurso.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecurso")
    private Long idRecurso;

    /**
     * Nombre del recurso.
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * Descripción del recurso.
     */
    @Column(name = "descripcion")
    private String descripcion;

    /**
     * Cantidad de veces que el recurso ha sido prestado.
     */
    @Column(name = "cantidadVecesPrestado")
    private int cantidadVecesPrestado;

    /**
     * Relación muchos a uno con la entidad HorarioDisponible.
     * El nombre de la columna que almacena esta relación es 'idHorarioDisponible'.
     */
    @ManyToOne
    @JoinColumn(name = "idHorarioDisponible")
    private HorarioDisponible idHorarioDisponible;

    /**
     * Cantidad de reservas del recurso, este campo no se almacena en la base de datos.
     */
    @Transient
    private int cantidaddereservas;

    /**
     * Relación muchos a uno con la entidad Unidad.
     * El nombre de la columna que almacena esta relación es 'idUnidad'.
     */
    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private Unidad idUnidad;
}
