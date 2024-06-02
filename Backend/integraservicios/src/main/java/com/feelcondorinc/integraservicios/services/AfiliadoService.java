package com.feelcondorinc.integraservicios.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.POJOS.RECURSOPOJO;
import com.POJOS.RESERVAPOJO;
import com.feelcondorinc.integraservicios.entities.EmpleadosSistema;
import com.feelcondorinc.integraservicios.entities.Horario;
import com.feelcondorinc.integraservicios.entities.HorarioDisponible;
import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.entities.Unidad;
import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.entities.models.EstadoRecurso;
import com.feelcondorinc.integraservicios.entities.models.EstadoReserva;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import com.feelcondorinc.integraservicios.repositories.HorarioDisponibleRepository;
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

    @Autowired
    private EmpleadosSistemaRepository empleadosSistemaRepository;


    public String crearReserva(RESERVAPOJO reservaPOJO) {

        // Conversión RESERVAPOJO a Reserva

        Reserva reserva = new Reserva();
        reserva.setHoraInicial(reservaPOJO.getHoraInicial());
        reserva.setMinutoInicial(reservaPOJO.getMinutoInicial());
        reserva.setHoraFinal(reservaPOJO.getHoraFinal());
        reserva.setMinutoFinal(reservaPOJO.getMinutoFinal());
        LocalDate fechareserva=LocalDate.parse(reservaPOJO.getFecha().substring(0,10));
        reserva.setFecha(java.sql.Date.valueOf(fechareserva));
        reserva.setEstadoReserva(EstadoReserva.PENDIENTE);
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
            reservaRepository.save(reserva);
            return null;
        } else {
            return "Usuario no encontrado";
        }
        
    }

    public List<String> verificarDisponibilidad(int idRecurso, String fecha) {

        Optional<Recurso> recursoOpt = recursoRepository.findById(Long.valueOf(idRecurso));
        if (recursoOpt.isEmpty()) {
            return List.of("Recurso no encontrado");
        }

        // Obtener el horario del recurso
        Recurso recurso = recursoOpt.get();
        HorarioDisponible horarioDisponibleRecurso = recurso.getIdHorarioDisponible();



        // Obtener el día de la semana de la fecha dada
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime();
        //int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        // create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String diaSemana = LocalDate.parse(fecha, formatter).getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();
        if(diaSemana.equals("MIÉRCOLES")){
            diaSemana="MIERCOLES";
        }
        if(diaSemana.equals("SÁBADO")){
            diaSemana="SABADO";
        }
        System.out.println(diaSemana+"perrito");



        // Obtener las reservas activas en la fecha especificada para el recurso
        ArrayList<Reserva> reservasActivas = new ArrayList<>(reservaRepository.reservasActivasPorFechaRecurso(fecha, Long.valueOf(idRecurso)));

       // Calcular las franjas horarias disponibles
        List<String> horariosDisponibles = calcularHorariosDisponiblesParaOtrasReservas(horarioDisponibleRecurso, reservasActivas, diaSemana);
        
        //Consultar hoorario del empleado ese dia de la semana
        
        List<Horario> horariosEmpleadosEnTurno = new ArrayList<>();
        
        Iterator<EmpleadosSistema> empleados = empleadosSistemaRepository.findByIdUnidad(recurso.getIdUnidad()).iterator();
        ArrayList<EmpleadosSistema> listaEmpleados = new ArrayList<EmpleadosSistema>();
        while (empleados.hasNext()) {
            EmpleadosSistema empleado = empleados.next();
            listaEmpleados.add(empleado);
        }
        

        for (EmpleadosSistema empleado: listaEmpleados){
            List<Horario> horariosEmpleado = empleado.getIdHorarioDisponible().getHorarios();
            for (Horario horario: horariosEmpleado){
                if (horario.getDiaSemana().equals(diaSemana)){
                    horariosEmpleadosEnTurno.add(horario);
                }
            }
        }

        List<Horario> horarioRecurso = obtenerHorarioPorDiaSemana(horarioDisponibleRecurso, diaSemana);
        
        
        try{

            //Ordenar y ecnontrar 
            LocalTime auxiliar = LocalTime.parse(formatearHorario(horariosEmpleadosEnTurno.get(0).getHoraInicial(),horariosEmpleadosEnTurno.get(0).getMinutoInicial()));

            for (Horario horario: horariosEmpleadosEnTurno){
                if (LocalTime.parse((formatearHorario(horario.getHoraInicial(),horario.getMinutoInicial()))).isBefore(auxiliar)){
                    if (horario.getHoraInicial()>=horarioRecurso.get(0).getHoraInicial()) {
                        if (horario.getMinutoInicial()<=horarioRecurso.get(0).getMinutoInicial()) {
                            auxiliar = LocalTime.parse((formatearHorario(horario.getHoraInicial(),horario.getMinutoInicial())));
                        }
                    }
                }
            }
    
            LocalTime horaInicialEmpleados = auxiliar;
            
            auxiliar = LocalTime.parse(formatearHorario(horariosEmpleadosEnTurno.get(0).getHoraFinal(),horariosEmpleadosEnTurno.get(0).getMinutoFinal()));
            for (Horario horario: horariosEmpleadosEnTurno){
                if (LocalTime.parse(formatearHorario(horario.getHoraFinal(),horario.getMinutoFinal())).isAfter(auxiliar)){
                    if (horario.getHoraFinal()<=horarioRecurso.get(horarioRecurso.size()-1).getHoraFinal()) {
                        if (horario.getMinutoFinal()>=horarioRecurso.get(horarioRecurso.size()-1).getMinutoFinal()) {
                            auxiliar = LocalTime.parse(formatearHorario(horario.getHoraFinal(),horario.getMinutoFinal()));
                        }
                    }
                }
            }
            List<String> horariofinalfinalestesi=new ArrayList<String>();
            LocalTime horarFinalEmpleado = auxiliar;
            for(String x:horariosDisponibles){
                LocalTime tiempoinicial=LocalTime.parse(x.substring(0,5));
                LocalTime tiempoFinal=LocalTime.parse(x.substring(6,11));
                if(tiempoinicial.isAfter(horaInicialEmpleados) || tiempoinicial.equals(horaInicialEmpleados)){
                    if(tiempoFinal.isBefore(horarFinalEmpleado) || tiempoFinal.equals(horarFinalEmpleado)){
                        horariofinalfinalestesi.add(x);
                    }
                }
            }


            return horariofinalfinalestesi;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        

        return horariosDisponibles;
    }

    private List<String> calcularHorariosDisponiblesParaOtrasReservas(HorarioDisponible horarioDisponible, List<Reserva> reservasActivas,
            String diaSemana) {
            

        List<String> horariosDisponibles = new ArrayList<>();
        
        // Obtener el horario del recurso para el día de la semana dado
        List<Horario> horariosRecurso = obtenerHorarioPorDiaSemana(horarioDisponible, diaSemana);
        if (horariosRecurso == null) {
            return List.of("No hay horario definido para este día");
        }
        //TODO System.out.println(horariosRecurso.toString()+"poerorepr    "+horariosRecurso.size());
        // Crear lista de franjas horarias ocupadas
        List<int[]> franjasOcupadas = new ArrayList<>();
        for (Reserva reserva : reservasActivas) {
            franjasOcupadas.add(new int[] {
                    reserva.getHoraInicial() * 60 + reserva.getMinutoInicial(),
                    reserva.getHoraFinal() * 60 + reserva.getMinutoFinal()
            });
        }
        // Ordenar franjas horarias ocupadas
        franjasOcupadas.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        for (Horario horarioRecurso: horariosRecurso){
            int horaInicio = horarioRecurso.getHoraInicial();
            int minutoInicio = horarioRecurso.getMinutoInicial();
            int horaFin = horarioRecurso.getHoraFinal();
            int minutoFin = horarioRecurso.getMinutoFinal();
            
            // Calcular franjas horarias disponibles
            int inicioDisponible = horaInicio * 60 + minutoInicio;
            for (int[] franja : franjasOcupadas) {
                if (inicioDisponible < franja[0]) {
                    horariosDisponibles.add(formatearHora(inicioDisponible) + "-" + formatearHora(franja[0]));
                }
                inicioDisponible = Math.max(inicioDisponible, franja[1]);
            }
            if (inicioDisponible < horaFin * 60 + minutoFin) {
                horariosDisponibles.add(formatearHora(inicioDisponible) + "-" + formatearHora(horaFin * 60 + minutoFin));
            }
        }

        return horariosDisponibles;
    }

    private List<Horario> obtenerHorarioPorDiaSemana(HorarioDisponible horarioDisponible, String diaSemana) {
        System.out.println(diaSemana);
        List<Horario> horariosRecurso = new ArrayList<>();
        for (Horario horario : horarioDisponible.getHorarios()) {
            if (horario.getDiaSemana().equals(diaSemana)) {
                horariosRecurso.add(horario);
            }
            
        }
        return horariosRecurso;
    }


    private String formatearHora(int minutos) {
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        return String.format("%02d:%02d", horas, minutosRestantes);
    }
    private String formatearHorario(int hora, int minuto){
        String horarioempleadoaux=hora+"";
        if(hora<10){
            horarioempleadoaux="0"+horarioempleadoaux;
        }
        horarioempleadoaux=horarioempleadoaux+":";
        if(minuto<10){
            horarioempleadoaux=horarioempleadoaux+"0";
        }
        horarioempleadoaux=horarioempleadoaux+minuto;
        return horarioempleadoaux;
    }
    public List<Reserva> ReservaUsuario(String idUsuario){
       Optional<Usuario> usuario= usuarioRepository.findById(idUsuario);
        try{
           List<Reserva> listareservas= reservaRepository.findByIdUsuario(usuario.get());
           return listareservas;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        
    }
}
    public String CancelarReserva(String idReserva){
        Optional<Reserva> reserva=reservaRepository.findById(Long.valueOf(idReserva));
        try{    
            Reserva actualizada=reserva.get();
            actualizada.setEstadoReserva(EstadoReserva.CANCELADA);
            reservaRepository.save(actualizada);

        }catch(Exception e){
            return e.getMessage();
        }
        return null;
    }
}
