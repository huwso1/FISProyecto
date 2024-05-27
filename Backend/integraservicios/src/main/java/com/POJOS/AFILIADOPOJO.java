package com.POJOS;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AFILIADOPOJO {
    private Long idUsuario;
    private String contrasenia;
    private String rolUsuario;
    private String nombres;
    private String apellidos;
    private String numIdentificacion;
    private String numContacto;
    private String telefono;
    private String email;

    @JsonCreator
    public AFILIADOPOJO(Long idUsuario, String contrasenia, String rolUsuario, String nombres, String apellidos,
                        String numIdentificacion, String numContacto, String direccion, String telefono, String email) {
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
        this.rolUsuario = rolUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numIdentificacion = numIdentificacion;
        this.numContacto = numContacto;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
