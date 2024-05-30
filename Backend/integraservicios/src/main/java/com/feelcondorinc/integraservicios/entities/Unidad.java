package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * La clase Unidad representa una entidad en la base de datos para almacenar información sobre unidades.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Unidades")
public class Unidad {

    /**
     * Identificador único de la unidad.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @Column(name = "idUnidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidad;

    /**
     * Nombre de la unidad.
     * La longitud máxima es de 30 caracteres.
     */
    @Column(name = "nombre", length=30)
    private String nombre;

    /**
     * Descripción de la unidad.
     */
    @Column(name = "descripcion")
    private String descripcion;

    /**
     * Intervalo mínimo de préstamo de la unidad, en minutos.
     */
    @Column(name = "intervaloMinimoPrestamo")
    private int intervaloMinimoPrestamo;

    /**
     * Cantidad de reservas, este campo no se almacena en la base de datos.
     */
    @Transient
    private int cantidaddereservas;

    /**
     * Relación uno a uno con la entidad HorarioDisponible.
     * El nombre de la columna que almacena esta relación es 'idHorarioDisponible'.
     */
    @OneToOne
    @JoinColumn(name = "idHorarioDisponible")
    private HorarioDisponible idHorarioDisponible;
}
