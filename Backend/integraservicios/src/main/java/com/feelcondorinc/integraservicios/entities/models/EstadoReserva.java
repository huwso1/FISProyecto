package com.feelcondorinc.integraservicios.entities.models;

/**
 * La enumeración EstadoReserva representa los posibles estados en los que puede estar una reserva en el sistema.
 */

public enum EstadoReserva {
    /**
     * Indica que la reserva está pendiente de confirmación.
     */
    PENDIENTE,


    /**
     * Indica que la reserva está en un estado intermedio donde se puede confirmar
     */
    PORCONFIRMAR,

    /**
     * Indica que la reserva ha sido confirmada.
     */
    CONFIRMADA,

    /**
     * Indica que la reserva ha sido cancelada.
     */
    CANCELADA,

    /**
     * Indica que la reserva ha finalizado y ha sido calificada.
     */
    FINALIZADACALIFICADA,

    /**
     * Indica que la reserva ha finalizado pero no ha sido calificada.
     */
    FINALIZADANOCALIFICADA
}
