package com.feelcondorinc.integraservicios.entities;

import com.feelcondorinc.integraservicios.entities.models.RolUsuario;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "rolUsuario")
    @Enumerated(EnumType.STRING)
    private RolUsuario rolUsuario;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "numIdentificacion")
    private String numIdentificacion;

    @Column(name = "numContacto")
    private String numContacto;

}
