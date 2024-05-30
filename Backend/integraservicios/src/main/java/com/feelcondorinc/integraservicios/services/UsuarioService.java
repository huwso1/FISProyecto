package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.Calificacion;
import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * El servicio UsuarioService proporciona métodos para realizar operaciones relacionadas con los usuarios en la aplicación.
 * Estos métodos incluyen la gestión de reservas, la consulta de reservas activas, la cancelación de reservas y la calificación del servicio.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Reserva un recurso de forma repetitiva.
     *
     * @param reserva La reserva a realizar.
     */
    public void reservarRecursoRepetitivo(Reserva reserva) {
        // TODO: Implementar la lógica para reservar un recurso de forma repetitiva
    }

    /**
     * Consulta las reservas activas de un usuario.
     *
     * @param usuario El usuario para el cual se consultan las reservas activas.
     * @return Una lista de reservas activas del usuario.
     */
    public List<Reserva> consultarReservasActivas(Usuario usuario) {
        // TODO: Implementar la lógica para consultar las reservas activas de un usuario
        return null;
    }

    /**
     * Cancela una lista de reservas activas.
     *
     * @param reservas La lista de reservas a cancelar.
     * @return La lista de reservas canceladas.
     */
    public List<Reserva> cancelarReservasActivas(List<Reserva> reservas) {
        // TODO: Implementar la lógica para cancelar las reservas activas
        return null;
    }

    /**
     * Califica un servicio.
     *
     * @param calificacion La calificación a realizar.
     * @return La calificación realizada.
     */
    public Calificacion calificarServicio(Calificacion calificacion) {
        // TODO: Implementar la lógica para calificar un servicio
        return null;
    }

    /**
     * Realiza el inicio de sesión de un usuario.
     *
     * @param usuario El usuario que intenta iniciar sesión.
     * @return El usuario logueado si las credenciales son correctas, de lo contrario, null.
     */
    public Usuario login(Usuario usuario) {
        Optional<Usuario> usuarioLogeado = usuarioRepository.findById(usuario.getIdUsuario());
        if (usuarioLogeado.isPresent() && usuarioLogeado.get().getContrasenia().equals(usuario.getContrasenia())) {
            return usuarioLogeado.get();
        }
        return null;
    }
}
