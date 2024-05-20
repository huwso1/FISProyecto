package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.Calificacion;
import com.feelcondorinc.integraservicios.repositories.CalificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {
    private CalificacionRepository calificacionRepository;

    public void guardar(Calificacion calificacion){
        calificacionRepository.save(calificacion);
    }

    public List<Calificacion> listarCalificaciones(){
        return (List<Calificacion>) calificacionRepository.findAll();
    }

}
