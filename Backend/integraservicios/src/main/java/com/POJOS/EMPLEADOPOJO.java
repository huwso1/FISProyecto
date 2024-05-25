package com.POJOS;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EMPLEADOPOJO {
private String Nombre;
private String Apellido;
private String Telefono;
private String Documento;
private String Lunesi;
private String Lunesf;
private String Martesi;
private String Martesf;
private String Miercolesi;
private String Miercolesf;
private String Juevesi;
private String Juevesf;
private String Viernesi;
private String Viernesf;
private String Sabadoi;
private String Sabadof;
private String idUnidad;

@JsonCreator
public EMPLEADOPOJO(String Nombre, String Apellido, String Telefono, String Documento, String Lunesi, String Lunesf,
        String Martesi, String Martesf, String Miercolesi, String Miercolesf, String Juevesi, String Juevesf,
        String Viernesi, String Viernesf, String Sabadosi, String Sabadosf, String idUnidad) {
    this.Nombre = Nombre;
    this.Apellido = Apellido;
    this.Telefono = Telefono;
    this.Documento = Documento;
    this.Lunesi = Lunesi;
    this.Lunesf = Lunesf;
    this.Martesi = Martesi;
    this.Martesf = Martesf;
    this.Miercolesi = Miercolesi;
    this.Miercolesf = Miercolesf;
    this.Juevesi = Juevesi;
    this.Juevesf = Juevesf;
    this.Viernesi = Viernesi;
    this.Viernesf = Viernesf;
    this.Sabadoi = Sabadosi;
    this.Sabadof = Sabadosf;
    this.idUnidad = idUnidad;
}
public String getApellido() {
    return Apellido;
}
public void setApellido(String apellido) {
    Apellido = apellido;
}
public String getTelefono() {
    return Telefono;
}
public void setTelefono(String telefono) {
    Telefono = telefono;
}
public String getDocumento() {
    return Documento;
}
public void setDocumento(String documento) {
    Documento = documento;
}
public String getNombre() {
    return Nombre;
}
public void setNombre(String nombre) {
    Nombre = nombre;
}
public String getLunesi() {
    return Lunesi;
}
public void setLunesi(String lunesi) {
    Lunesi = lunesi;
}
public String getLunesf() {
    return Lunesf;
}
public void setLunesf(String lunesf) {
    Lunesf = lunesf;
}
public String getMartesi() {
    return Martesi;
}
public void setMartesi(String martesi) {
    Martesi = martesi;
}
public String getMartesf() {
    return Martesf;
}
public void setMartesf(String martesf) {
    Martesf = martesf;
}
public String getMiercolesi() {
    return Miercolesi;
}
public void setMiercolesi(String miercolesi) {
    Miercolesi = miercolesi;
}
public String getMiercolesf() {
    return Miercolesf;
}
public void setMiercolesf(String miercolesf) {
    Miercolesf = miercolesf;
}
public String getJuevesi() {
    return Juevesi;
}
public void setJuevesi(String juevesi) {
    Juevesi = juevesi;
}
public String getJuevesf() {
    return Juevesf;
}
public void setJuevesf(String juevesf) {
    Juevesf = juevesf;
}
public String getViernesi() {
    return Viernesi;
}
public void setViernesi(String viernesi) {
    Viernesi = viernesi;
}
public String getViernesf() {
    return Viernesf;
}
public void setViernesf(String viernesf) {
    Viernesf = viernesf;
}


public String getSabadoi() {
    return Sabadoi;
}
public void setSabadoi(String sabadoi) {
    Sabadoi = sabadoi;
}
public String getSabadof() {
    return Sabadof;
}
public void setSabadof(String sabadof) {
    Sabadof = sabadof;
}
public String getIdUnidad() {
    return idUnidad;
}
public void setIdUnidad(String idUnidad) {
    this.idUnidad = idUnidad;
}
}
