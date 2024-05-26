package com.feelcondorinc.integraservicios.services;

import com.POJOS.UNIDADPOJO;
import com.POJOS.AfiliadoPOJO;
import com.feelcondorinc.integraservicios.entities.*;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import com.feelcondorinc.integraservicios.repositories.ReservaRepository;
import com.feelcondorinc.integraservicios.repositories.UnidadRepository;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;
import com.feelcondorinc.integraservicios.services.AfiliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmpleadosSistemaRepository empleadosSistemaRepository;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private AfiliadoService afiliadoService;
   

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

    public String crearAfiliado(AfiliadoPOJO afiliadoPOJO) {
        try {
            afiliadoService.crearAfiliado(afiliadoPOJO);
            return "Afiliado creado con éxito";
        } catch (Exception e) {
            return "Error al crear afiliado: " + e.getMessage();
        }
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


    public Usuario Login(Usuario usuario){
        
        Optional<Usuario> usuariologeado=usuarioRepository.findById(usuario.getIdUsuario());
        System.out.println(usuariologeado.isPresent());

        if(usuariologeado.isPresent()){
            if(usuariologeado.get().getContrasenia().equals(usuario.getContrasenia())){
            return usuariologeado.get();
        }
        }

        return null;
    }

    
}
