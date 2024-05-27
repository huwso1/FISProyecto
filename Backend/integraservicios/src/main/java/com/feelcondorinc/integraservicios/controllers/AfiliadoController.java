package com.feelcondorinc.integraservicios.controllers;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POJOS.RECURSOPOJO;
import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.services.AfiliadoService;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
@RequestMapping(value="/reserva")
public class AfiliadoController {
    

    private AfiliadoService afiliadoService;

    @PostMapping(value="/CrearReserva")
    public ResponseEntity crearReserva(@RequestBody Reserva reserva){
    
    String hola=afiliadoService.crearReserva(reserva);
    
    JSONObject respuesta=new JSONObject();
    respuesta.put("message",hola);
    if(hola==null){
        return new ResponseEntity(respuesta.toString(),HttpStatus.OK);
    }
    
    
    return new ResponseEntity("banana",HttpStatus.BAD_REQUEST);

}
}
