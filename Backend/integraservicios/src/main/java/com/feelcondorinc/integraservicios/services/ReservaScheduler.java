package com.feelcondorinc.integraservicios.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.repositories.ReservaRepository;

@Component
public class ReservaScheduler {

//     @Autowired
//     private EmpleadoService empleadoService;

//     @Autowired
//     private ReservaRepository reservaRepository;


//     private List<Reserva> reservas = todasReservas();
//     private List<Reserva> reservasPendientes = new CopyOnWriteArrayList<>();

// //    public List<Reserva> findAll() {
// //        List<Reserva> reservas = new CopyOnWriteArrayList<>();
// //        try {
// //
// //            reservaRepository.findAll().forEach(reservas::add);
// //            System.out.println("algo de algo");
// //            return reservas;
// //        }catch(Exception e){
// //            System.out.println(e.getMessage()+"nada de nadaaaaaaaaaaaaaaaaaaaaaaaa");
// //            return null;
// //        }
// //    }

//     public ArrayList<Reserva> todasReservas() {
//         ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
// //        try{
// //            Iterator<Reserva> reservas = reservaRepository.findAll().iterator();
// //            while (reservas.hasNext()) {
// //                Reserva reserva = reservas.next();
// //                listaReservas.add(reserva);
// //            }
// //        } catch (Exception e){
// //            System.out.println(e.getMessage());
// //        }
//         Optional<Reserva> reservaopt = reservaRepository.findById(Long.valueOf("1"));
//         Reserva reserva = reservaopt.get();
//         listaReservas.add(reserva);
//         System.out.println("se logrooooooo"+listaReservas.getClass());
//         return listaReservas;
//     }



//     // Tarea programada para verificar las reservas cada segundo
//     @Scheduled(fixedRate = 5000)
//     public void validarReservaciones() {
//         try {
//             reservasPendientes.clear();
//             for (Reserva reserva : reservas) {
//                 if (empleadoService.validarHoraReserva(reserva)) {
//                     reservasPendientes.add(reserva);
//                     System.out.println("Reservation " + reserva.getIdReserva() + " is within the time window.");
//                 }
//             }
//         }catch(Exception e){
//             //System.out.println(e.getMessage()+"se intento");
//         }
//     }

//     // Método para obtener reservas dentro del intervalo
//     public List<Reserva> getReservasPendientes(String idUnidad) {
//        ArrayList<Reserva> reservas3 = new ArrayList<>(reservasPendientes);
//        List<Reserva> reservasAEntregar = new ArrayList<>();
//         for (Reserva reserva : reservas3) {
//             if(reserva.getIdRecurso().getIdUnidad().getIdUnidad() == Long.valueOf(idUnidad)){
//                 reservasAEntregar.add(reserva);
//             }
//         }
//         return reservasAEntregar;
//     }
}
