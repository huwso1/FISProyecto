package com.feelcondorinc.integraservicios.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POJOS.RECURSOPOJO;
import com.POJOS.RESERVAPOJO;
import com.feelcondorinc.integraservicios.entities.Horario;
import com.feelcondorinc.integraservicios.entities.HorarioDisponible;
import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.entities.Unidad;
import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.entities.models.EstadoRecurso;
import com.feelcondorinc.integraservicios.repositories.RecursoRepository;
import com.feelcondorinc.integraservicios.repositories.ReservaRepository;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;



@Service
public class AfiliadoService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String crearReserva(RESERVAPOJO reservaPOJO) {
        // Conversión RESERVAPOJO a Reserva
        Reserva reserva = new Reserva();
        reserva.setHoraInicial(reservaPOJO.getHoraInicial());
        reserva.setMinutoInicial(reservaPOJO.getMinutoInicial());
        reserva.setHoraFinal(reservaPOJO.getHoraFinal());
        reserva.setMinutoFinal(reservaPOJO.getMinutoFinal());
        reserva.setFecha(reservaPOJO.getFecha());
        reserva.setEstadoReserva(reservaPOJO.getEstadoReserva());
        reserva.setObservaciones(reservaPOJO.getObservaciones());

        // Asociar el recurso a la reserva
        Optional<Recurso> recursoOpt = recursoRepository.findById(reservaPOJO.getIdRecurso());
        if (recursoOpt.isPresent()) {
            reserva.setIdRecurso(recursoOpt.get());
        } else {
            return "Recurso no encontrado";
        }

        // Asociar el usuario a la reserva
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(reservaPOJO.getIdUsuario());
        if (usuarioOpt.isPresent()) {
            reserva.setIdUsuario(usuarioOpt.get());
        } else {
            return "Usuario no encontrado";
        }

}
