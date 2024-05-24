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
    private Long idReserva;

    @Column(name = "horaInicial")
    private int horaInicial;

    @Column(name = "minutoInicial")
    private int minutoInicial;

    @Column(name = "horaFinal")
    private int horaFinal;

    @Column(name = "minutoFinal")
    private int minutoFinal;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

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
