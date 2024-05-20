package com.feelcondorinc.integraservicios.entities;

import com.feelcondorinc.integraservicios.entities.models.EstadoReserva;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "Reservas")
public class Reserva {

    @Id
    @Column(name = "idReserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFinal")
    private Date fechaFinal;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idRecurso", nullable = false)
    private Recurso idRecurso;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;
}
