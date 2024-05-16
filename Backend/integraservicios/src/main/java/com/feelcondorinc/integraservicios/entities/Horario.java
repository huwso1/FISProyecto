package com.feelcondorinc.integraservicios.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "HorariosDisponibles")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorario")
    private int idHorario;

    @Column(name = "horaInicial")
    private int horaInicial;

    @Column(name = "minutoInicial")
    private int minutoInicial;

    @Column(name = "horaFinal")
    private int horaFinal;

    @Column(name = "minutoFinal")
    private int minutoFinal;

    //TODO llave foranea
    private int idHorariosDisponibles;
}
