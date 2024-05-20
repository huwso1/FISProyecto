package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "Recursos")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecurso")
    private int idRecurso;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidadVecesPrestado")
    private int cantidadVecesPrestado;

    @ManyToOne
    @JoinColumn(name = "idHorarioDisponible")
    private HorarioDisponible idHorariosDisponibles;

    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private Unidad idUnidad;
}
