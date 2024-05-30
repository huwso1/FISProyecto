package com.feelcondorinc.integraservicios.entities;

import com.feelcondorinc.integraservicios.entities.models.RolUsuario;
import jakarta.persistence.*;
import lombok.*;

/**
 * La clase Usuario representa una entidad en la base de datos para almacenar información de los usuarios.
 * Esta clase está anotada con JPA y Lombok para facilitar la persistencia y reducir la cantidad de código boilerplate.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuarios")
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @Column(name = "idUsuario")
    private String idUsuario;

    /**
     * Contraseña del usuario.
     * La longitud máxima es de 25 caracteres.
     */
    @Column(name = "contrasenia", length=25)
    private String contrasenia;

    /**
     * Rol del usuario, almacenado como una cadena de texto.
     * Utiliza un enum para representar los roles posibles.
     * La longitud máxima es de 8 caracteres.
     */
    @Column(name = "rolUsuario", length=8)
    @Enumerated(EnumType.STRING)
    private RolUsuario rolUsuario;

    /**
     * Nombres del usuario.
     * La longitud máxima es de 20 caracteres.
     */
    @Column(name = "nombres", length=20)
    private String nombres;

    /**
     * Apellidos del usuario.
     * La longitud máxima es de 20 caracteres.
     */
    @Column(name = "apellidos", length=20)
    private String apellidos;

    /**
     * Número de identificación del usuario.
     * La longitud máxima es de 15 caracteres.
     */
    @Column(name = "numIdentificacion", length=15)
    private String numIdentificacion;

    /**
     * Número de contacto del usuario.
     * La longitud máxima es de 10 caracteres.
     */
    @Column(name = "numContacto", length=10)
    private String numContacto;
}
