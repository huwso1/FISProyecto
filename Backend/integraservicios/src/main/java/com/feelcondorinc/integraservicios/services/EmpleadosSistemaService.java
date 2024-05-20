package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.EmpleadosSistema;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosSistemaService {

    private EmpleadosSistemaRepository empleadosSistemaRepository;


    public void guardar(EmpleadosSistema empleadosSistema){
        empleadosSistemaRepository.save(empleadosSistema);
    }
    
}