package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.*;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import com.feelcondorinc.integraservicios.repositories.ReservaRepository;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;
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
