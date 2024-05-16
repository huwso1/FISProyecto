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
    private int idUnidad;

    @Column(name = "nombre")
    private int nombre;

    @Column(name = "intervaloMinimo")
    private int intervaloMinimo;

    //TODO llaves foraneas
    private int idHorariosDisponibles;

}
