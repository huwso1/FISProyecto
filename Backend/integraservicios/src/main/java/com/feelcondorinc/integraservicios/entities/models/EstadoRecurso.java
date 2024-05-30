package com.feelcondorinc.integraservicios.entities.models;

/**
 * La enumeración EstadoRecurso representa los posibles estados en los que puede estar un recurso en el sistema.
 */
public enum EstadoRecurso {
    /**
     * Indica que el recurso no está disponible.
     */
    NODISPONIBLE,

    /**
     * Indica que el recurso está disponible.
     */
    DISPONIBLE,

    /**
     * Indica que el recurso está en reserva.
     */
    ENRESERVA,

    /**
     * Indica que el recurso ha sido prestado.
     */
    PRESTADO
}
