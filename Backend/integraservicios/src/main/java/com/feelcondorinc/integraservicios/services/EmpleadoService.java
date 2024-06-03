package com.feelcondorinc.integraservicios.services;

import java.time.LocalDateTime;
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

@Service
public class EmpleadoService {

    @Autowired
    private ReservaRepository reservaRepository;

    private List<Reserva> reservas = agregarReservas();


    //TODO: Arreglar pq no encuentra las reservas
    private ArrayList<Reserva> agregarReservas(){
        ArrayList<Reserva> reservasNuevas = new ArrayList<>();
        try{
            assert reservaRepository != null;
            Iterator<Reserva> listaReservas = reservaRepository.findAll().iterator();

            while(listaReservas.hasNext()){
                reservasNuevas.add(listaReservas.next());
            }

        }catch (Exception e){
            System.out.println("ola");
        }
        System.out.println(reservasNuevas);
        return reservasNuevas;
    }
    


    @Scheduled(fixedRate = 5000)
    public void cambiarAConfirmarble(){
        try {            
            for (Reserva reserva : reservas) {
                if (validarHoraReserva(reserva)) {
                    reserva.setEstadoReserva(EstadoReserva.PORCONFIRMAR);
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
            LocalDateTime horaReserva = formatearHora(reserva.getHoraInicial(), reserva.getMinutoInicial());
            LocalDateTime horaLocal = formatearHora(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
            LocalDateTime cincoMinutosAntes = horaReserva.minusMinutes(5);
            LocalDateTime cincoMinutosDespues = horaReserva.plusMinutes(5);
            return (horaLocal.isAfter(cincoMinutosAntes) && horaLocal.isBefore(cincoMinutosDespues)) || (horaLocal.equals(cincoMinutosDespues)) || horaLocal.equals(cincoMinutosAntes);
        }
        else return false;   
    }



    public LocalDateTime formatearHora(int hora, int minuto){
        String horarioFormateado=hora+"";
        if(hora<10){
            horarioFormateado="0"+horarioFormateado;
        }
        horarioFormateado=horarioFormateado+":";
        if(minuto<10){
            horarioFormateado=horarioFormateado+"0";
        }
        horarioFormateado=horarioFormateado+minuto;
        return LocalDateTime.parse(horarioFormateado);
    }


}
