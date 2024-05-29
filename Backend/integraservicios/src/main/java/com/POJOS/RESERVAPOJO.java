package com.POJOS;

import com.feelcondorinc.integraservicios.entities.models.EstadoReserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RESERVAPOJO {

    private Long idReserva;
    private int horaInicial;
    private int minutoInicial;
    private int horaFinal;
    private int minutoFinal;
    private String fecha;
    private EstadoReserva estadoReserva;
    private String observaciones;
    private Long idRecurso;  
    private String idUsuario;  

}
