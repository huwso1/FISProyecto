package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "EmpleadosSistema")
public class EmpleadosSistema{
    @Id
    @Column(name = "idEmpleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;

    @Column(name = "correoCorporativo")
    private String correoCorporativo;

    @ManyToOne
    @JoinColumn(name = "idHorarioEmpleado")
    private HorarioDisponible idHorarioDisponible;
    @ManyToOne
    @JoinColumn(name = "idUnidadAsocaciada",nullable = false)
    private Unidad idUnidad;
    @OneToOne
    @JoinColumn(name = "idUsuarioEmpleado", nullable = false)
    private Usuario idUsuario;
}
