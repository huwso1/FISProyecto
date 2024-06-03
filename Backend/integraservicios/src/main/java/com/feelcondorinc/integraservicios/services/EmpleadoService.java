package com.feelcondorinc.integraservicios.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import com.feelcondorinc.integraservicios.entities.Unidad;
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

    // @Autowired
    // private ReservaRepository reservaRepository; 

    // @Autowired
    // private EmpleadosSistemaRepository empleadosSistemaRepository;

    // public List<Reserva> obtenerListaReservasPendientes(String idEmpleado){
    //     Optional<EmpleadosSistema> empleadoOpt = empleadosSistemaRepository.findById(Long.parseLong(idEmpleado));
    //     if (empleadoOpt.isEmpty()) {
    //         System.out.println("empleado no encontrado");
    //     }
    //     EmpleadosSistema empleadoSistema = empleadoOpt.get();
    //     Long idUnidad = empleadoSistema.getIdUnidad().getIdUnidad();

    //     Collection<Reserva> coleccionReservas = reservaRepository.reservasActivasUnidad(idUnidad);
    //     ArrayList<Reserva> reservas = new ArrayList<>(coleccionReservas);
    //     return reservas;
    // }



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


}
