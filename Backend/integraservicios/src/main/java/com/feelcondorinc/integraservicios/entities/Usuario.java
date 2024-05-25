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
    private Long idUsuario;

    @Column(name = "contrasenia", length=10)
    private String contrasenia;

    @Column(name = "rolUsuario", length=8)
    @Enumerated(EnumType.STRING)
    private RolUsuario rolUsuario;

    @Column(name = "nombres", length=20)
    private String nombres;

    @Column(name = "apellidos" , length=20)
    private String apellidos;

    @Column(name = "numIdentificacion", length=15)
    private String numIdentificacion;

    @Column(name = "numContacto", length=10)
    private String numContacto;

}
