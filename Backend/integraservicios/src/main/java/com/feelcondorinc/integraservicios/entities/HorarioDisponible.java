package com.feelcondorinc.integraservicios.entities;

import com.feelcondorinc.integraservicios.entities.models.EstadoRecurso;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "horarioDisponible", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Horario> Horarios = new ArrayList<>();
}
