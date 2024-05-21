package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "Unidades")
public class Unidad {
    @Id
    @Column(name = "idUnidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidad;

    @Column(name = "nombre")
    private int nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "intervaloMinimoPrestamo")
    private int intervaloMinimoPrestamo;

    @OneToOne
    @JoinColumn(name = "idHorarioDisponible")
    private HorarioDisponible idHorarioDisponible;
}
