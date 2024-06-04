package com.feelcondorinc.integraservicios.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Unidad;
import com.feelcondorinc.integraservicios.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.feelcondorinc.integraservicios.entities.EmpleadosSistema;
import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.entities.models.EstadoReserva;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import com.feelcondorinc.integraservicios.repositories.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoService {

    @Autowired
    private ReservaRepository reservaRepository;

    private List<Reserva> reservas;
    @Autowired
    private RecursoRepository recursoRepository;
    @Autowired
    private ReservaScheduler reservaScheduler;


    public EmpleadoService(ReservaRepository reservaRepository){
        
        this.reservaRepository=reservaRepository;
    }

    
    private ArrayList<Reserva> agregarReservas(){
        ArrayList<Reserva> reservasNuevas = new ArrayList<>();
        try{
           
            List<Reserva> listaReservas = reservaRepository.findreservas();

           reservasNuevas=new ArrayList(listaReservas);
           

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return reservasNuevas;
    }
    

    
    @Scheduled(fixedDelay=5000)
    public void cambiarAConfirmarble(){
        reservas=agregarReservas();
        try {            
            for (Reserva reserva : reservas) {
                if (validarHoraReserva(reserva)) {
                    reserva.setEstadoReserva(EstadoReserva.PORCONFIRMAR);
                    reservaRepository.save(reserva);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage()+"se intento");
        }
    }



    public boolean validarHoraReserva(Reserva reserva) {

        if (reserva.getEstadoReserva().name().equals("PENDIENTE")) {
            LocalTime horaReserva = formatearHora(reserva.getHoraInicial(), reserva.getMinutoInicial());
            LocalTime horaLocal = formatearHora(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
            LocalTime cincoMinutosAntes = horaReserva.minusMinutes(5);
            LocalTime cincoMinutosDespues = horaReserva.plusMinutes(5);
            return (horaLocal.isAfter(cincoMinutosAntes) && horaLocal.isBefore(cincoMinutosDespues)) || (horaLocal.equals(cincoMinutosDespues)) || horaLocal.equals(cincoMinutosAntes);
        }
        else return false;   
    }



    public LocalTime formatearHora(int hora, int minuto){
        String horarioFormateado="";
        try{
        if(hora<10){
            horarioFormateado=horarioFormateado+"0";
            
        }
        horarioFormateado=horarioFormateado+hora+":";
        if(minuto<10){
            horarioFormateado=horarioFormateado+"0";
        }
        horarioFormateado=horarioFormateado+minuto;
        
        return LocalTime.parse(horarioFormateado);
    }catch(Exception e){
        System.out.println(e.getMessage()+"Error en formatear hora");
        return null;
    }
    }

    public String registrarPrestamo(int idReserva){
        Reserva reserva;
        Optional<Reserva> reservaOpt = reservaRepository.findById( Long.valueOf(idReserva));
        try {
            reserva = reservaOpt.get();
            reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
            reservaRepository.save(reserva);
            Optional<Recurso> recursoOpt = recursoRepository.findById(reserva.getIdRecurso().getIdRecurso());
            try {
                Recurso recurso = recursoOpt.get();
                recurso.setCantidaddereservas(recurso.getCantidaddereservas()+1);
                recursoRepository.save(recurso);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return "reserva registrada con éxito";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "no existe la reserva";
        }
    }

    public String registrarDevolucion (int idReserva){
        Reserva reserva;
        Optional<Reserva> reservaOpt = reservaRepository.findById( Long.valueOf(idReserva));
        try {
            reserva = reservaOpt.get();
            reserva.setEstadoReserva(EstadoReserva.FINALIZADANOCALIFICADA);
            reservaRepository.save(reserva);
            Optional<Recurso> recursoOpt = recursoRepository.findById(reserva.getIdRecurso().getIdRecurso());
            return "reserva finalizada con éxito";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "no existe la reserva";
        }
    }
}
