package com.feelcondorinc.integraservicios.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POJOS.RECURSOPOJO;
import com.POJOS.RESERVAPOJO;
import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.entities.Unidad;
import com.feelcondorinc.integraservicios.services.AfiliadoService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping(value = "/Afiliado")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;

   

    @PostMapping(value = "/DisponibilidadRecurso")
    public ResponseEntity<List<Recurso>> consultarRecursosDisponibles(@RequestBody String body) {
        JSONObject request = new JSONObject(body);
        List<String> listaHorariosRecursosDisponibles = afiliadoService.verificarDisponibilidad(request.getInt("idRecurso"), request.getString("fecha"));
        if (listaHorariosRecursosDisponibles != null) {
            return new ResponseEntity(listaHorariosRecursosDisponibles, HttpStatus.OK);
        }

        return new ResponseEntity("{ \"message\":\"salio mal\"}", HttpStatus.BAD_REQUEST);

    }
    @PostMapping(value = "/CrearReserva")
    public ResponseEntity CrearReserva(@RequestBody RESERVAPOJO reserva) {
        
        String message = afiliadoService.crearReserva(reserva);
        if (message == null) {
            return new ResponseEntity(message, HttpStatus.OK);
        }

        return new ResponseEntity("{ \"message\":\"salio mal\"}", HttpStatus.BAD_REQUEST);

    }
}
