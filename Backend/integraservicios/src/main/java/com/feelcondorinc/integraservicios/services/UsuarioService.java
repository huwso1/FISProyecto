package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.*;
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


    // TODO logica de servicios
    //Accionar Administrador
    public void asignarRangoHorarioUnidad(){

    }

    public List<Recurso> consultarRecursosMasReservados(){
        return null;
    }

    //TODO se necesita query personalizada
   public void crearEmpleado(Usuario empleado){
//        usuarioRepository.save(empleado);
//        empleadosSistemaRepository.guardarEmpleado();
    }

    public void crearAfiliado(Usuario afiliado){
        usuarioRepository.save(afiliado);
    }

// TODO se necesita query personalizada
    //Accionar Empleado
    public List<Reserva> consultarReservasEnUnidad (Unidad unidad){
////        return reservaRepository.findAllByUnidad(unidad.getIdUnidad());
        return null;
    }

    public List<Reserva> consultarReservasEnRecurso(Recurso recurso){
////        return reservaRepository.findAllByRecurso(recurso.getIdRecurso());
        return  null;
    }

    public void registrarPrestamo(Reserva reserva){

    }

    public void devolverRecurso(Reserva reserva){

    }
//
//
//
//    //Accionar Empleado
    public void reservarRecurso(Reserva reserva){
        reservaRepository.save(reserva);
    }

    //Accionar Afiliado
    public void reservarRecursoRepetitivo(Reserva reserva){

    }

    public List<Reserva> consultarReservasActivas(Usuario usuario){
        return null;
    }
    public List<Reserva> cancelarReservasActivas(List<Reserva> reservas){
        return null;
    }

    public Calificacion calificarServicio(Calificacion calificacion){
        return null;
    }
}
