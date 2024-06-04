package com.feelcondorinc.integraservicios.controllers;

import java.util.List;

import com.feelcondorinc.integraservicios.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.services.ReservaScheduler;

@RestController
@CrossOrigin(origins={"http://localhost:3000","http://10.22.45.217:3000"})
@RequestMapping(value="/Empleado")

public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/RegistrarPresatmo")
    public ResponseEntity RegistrarPrestamo(@RequestBody int idReserva){
        String message=empleadoService.registrarPrestamo(idReserva);
        if(message==null){
            return new ResponseEntity(message, HttpStatus.OK);
        }
        return new ResponseEntity("{ \" " + message +"\":\"salio mal\"}",HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/RegistrarDevolucion")
    public ResponseEntity RegistrarDevolucion(@RequestBody int idReserva){
        String message=empleadoService.registrarDevolucion(idReserva);
        if(message==null){
            return new ResponseEntity(message, HttpStatus.OK);
        }
        return new ResponseEntity("{ \" " + message +"\":\"salio mal\"}",HttpStatus.BAD_REQUEST);
    }

}
