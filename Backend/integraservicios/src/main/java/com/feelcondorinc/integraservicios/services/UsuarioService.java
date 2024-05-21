package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.entities.Unidad;
import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import com.feelcondorinc.integraservicios.repositories.ReservaRepository;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmpleadosSistemaRepository empleadosSistemaRepository;
    @Autowired
    private ReservaRepository reservaRepository;

    //Accionar Administrador
    public void asignarRangoHorarioUnidad(){

    }

    public List<Recurso> consultarRecursosMasReservados(){
        return null;
    }

    public void crearEmpleado(Usuario empleado){
        usuarioRepository.save(empleado);
        empleadosSistemaRepository.guardarEmpleado();
    }

    public void crearAfiliado(Usuario afiliado){
        usuarioRepository.save(afiliado);
    }



//    //Accionar Empleado
//    public List<Reserva> consultarReservasEnUnidad (Unidad unidad){
//        return reservaRepository.findAllByUnidad(unidad.getIdUnidad());
//    }
//
//    public List<Reserva> consultarReservasEnRecurso(Recurso recurso){
//        return reservaRepository.findAllByRecurso(recurso.getIdRecurso());
//    }

    public void registrarPrestamo(Reserva reserva){

    }

    public void devolverRecurso(Reserva reserva){

    }



    //Accionar Empleado
    public void reservarRecurso(Reserva reserva){
        reservaRepository.save(reserva);
    }

    //TODO public void reservarRecursoRepetitivo(Reserva reserva)
}
