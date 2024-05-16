package com.feelcondorinc.integraservicios.entities;

import com.feelcondorinc.integraservicios.entities.models.EstadoRecurso;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "HorariosDisponibles")
public class HorarioDisponible {

    @Id
    @Column(name = "idHorariosDisponibles")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorariosDisponibles;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFinal")
    private Date fechaFinal;

    @Column(name = "estadoRecurso")
    @Enumerated(EnumType.STRING)
    private EstadoRecurso estadoRecurso;
}
