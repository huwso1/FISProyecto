package com.feelcondorinc.integraservicios.controllers;

import java.util.List;

import com.feelcondorinc.integraservicios.services.EmpleadoService;

import org.json.JSONObject;
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

    @PostMapping("/RegistrarPrestamo")
    public ResponseEntity RegistrarPrestamo(@RequestBody String idReserva){
        JSONObject requests=new JSONObject(idReserva);

        String message=empleadoService.registrarPrestamo(requests.getInt("idReserva"));
        if(message==null){
            return new ResponseEntity(message, HttpStatus.OK);
        }
        return new ResponseEntity("{ \" " + message +"\":\"salio mal\"}",HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/RegistrarDevolucion")
    public ResponseEntity RegistrarDevolucion(@RequestBody String idReserva){
        JSONObject requests=new JSONObject(idReserva);
        int calidad=requests.getInt("calidad");
        int tratopersonal=requests.getInt("tratopersonal");
        int cumplimientohorario=requests.getInt("cumplimientohorario");
        int estado=requests.getInt("estado");
        String idEmpleado=requests.getString("idEmpleado");
        int reserva=requests.getInt("idReserva");
        String message=empleadoService.registrarDevolucion(reserva,calidad,cumplimientohorario,tratopersonal,estado,idEmpleado);
        System.out.println(message);
        if(message==null){
            return new ResponseEntity(message, HttpStatus.OK);
        }
        return new ResponseEntity("{ \" " + message +"\":\"salio mal\"}",HttpStatus.BAD_REQUEST);
    }

}
