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
    private Long idCalificacion;

    @Column(name = "cumplimientoHorario")
    private int cumplimientoHorario;

    @Column(name = "calidadRecurso")
    private int calidadRecurso;

    @Column(name = "estadoRecurso")
    private int estadoRecurso;

    @Column(name = "tratoPersonal")
    private int tratoPersonal;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idEmpleadoCalificado", nullable = false)
    private EmpleadosSistema idEmpleado;

    @OneToOne
    @JoinColumn(name = "idReservaCalificada",nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "idAfiliadoCalificador", nullable = false)
    private Usuario idUsuario;

}
