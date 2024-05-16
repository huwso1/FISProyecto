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
public class EmpleadosSistema {
    @Id
    @Column(name = "idEmpleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;

    @Column(name = "correoCorporativo")
    private String correoCorporativo;


    //TODO llaves foraneas
    private int idHorariosDisponibles;
    private int idUnidad;
    private int idUsuario;
}
