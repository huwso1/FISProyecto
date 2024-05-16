package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "Calificaciones")
public class Calificacion {

    @Id
    @Column(name = "idCalificaion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalificacion;

    @Column(name = "cumplimientoHorario")
    private int cumplimientoHorario;

    @Column(name = "calidadRecurso")
    private int calidadRecurso;

    @Column(name = "tratoPersonal")
    private int tratoPersonal;

    @Column(name = "observaciones")
    private String observaciones;


    //TODO Llaves foraneas
    private int idEmpleado;
    private int idReserva;
    private int idUsuario;

}
