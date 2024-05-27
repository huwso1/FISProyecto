package com.feelcondorinc.integraservicios.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
            return "Exito";
        } else {
            return "Usuario no encontrado";
        }
    }

    public List<String> verificarDisponibilidad(String idRecurso, String fecha) {

        Optional<Recurso> recursoOpt = recursoRepository.findById(Long.valueOf(idRecurso));
        if (recursoOpt.isEmpty()) {
            return List.of("Recurso no encontrado");
        }

        // Obtener el día de la semana de la fecha dada
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime();
        //int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        // create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        int diaSemana = LocalDate.parse(fecha, formatter).getDayOfWeek().getValue();

        // Obtener el horario del recurso
        Recurso recurso = recursoOpt.get();
        HorarioDisponible horarioDisponible = recurso.getIdHorarioDisponible();

        // Obtener las reservas activas en la fecha especificada para el recurso
        List<Reserva> reservasActivas = (List)(reservaRepository.ReservasActivasPorFechaRecurso(fecha, Long.valueOf(idRecurso)));

        // Calcular las franjas horarias disponibles
        List<String> horariosDisponibles = calcularHorariosDisponibles(horarioDisponible, reservasActivas, diaSemana);

        return horariosDisponibles;
    }

    private List<String> calcularHorariosDisponibles(HorarioDisponible horarioDisponible, List<Reserva> reservasActivas,
            int diaSemana) {
        List<String> horariosDisponibles = new ArrayList<>();

        // Obtener el horario del recurso para el día de la semana dado
        Horario horarioRecurso = obtenerHorarioPorDiaSemana(horarioDisponible, diaSemana);
        if (horarioRecurso == null) {
            return List.of("No hay horario definido para este día");
        }

        int horaInicio = horarioRecurso.getHoraInicial();
        int minutoInicio = horarioRecurso.getMinutoInicial();
        int horaFin = horarioRecurso.getHoraFinal();
        int minutoFin = horarioRecurso.getMinutoFinal();

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

        // Calcular franjas horarias disponibles
        int inicioDisponible = horaInicio * 60 + minutoInicio;
        for (int[] franja : franjasOcupadas) {
            if (inicioDisponible < franja[0]) {
                horariosDisponibles.add(formatearHora(inicioDisponible) + " - " + formatearHora(franja[0]));
            }
            inicioDisponible = Math.max(inicioDisponible, franja[1]);
        }
        if (inicioDisponible < horaFin * 60 + minutoFin) {
            horariosDisponibles.add(formatearHora(inicioDisponible) + " - " + formatearHora(horaFin * 60 + minutoFin));
        }

        return horariosDisponibles;
    }

    private Horario obtenerHorarioPorDiaSemana(HorarioDisponible horarioDisponible, int diaSemana) {
        for (Horario horario : horarioDisponible.getHorarios()) {
            if (horario.getDiaSemana().equals(diaSemana)) {
                return horario;
            }
        }
        return null;
    }

    private String formatearHora(int minutos) {
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        return String.format("%02d:%02d", horas, minutosRestantes);
    }
}
