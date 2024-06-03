package com.feelcondorinc.integraservicios.controllers;

import java.util.List;

import com.feelcondorinc.integraservicios.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feelcondorinc.integraservicios.entities.Reserva;
import com.feelcondorinc.integraservicios.services.ReservaScheduler;

@RestController
@CrossOrigin(origins={"http://localhost:3000","http://10.22.45.217:3000"})
@RequestMapping(value="/Empleado")

public class EmpleadoController {

    // @Autowired
    // private ReservaScheduler reservaScheduler;

    // @Autowired
    // private EmpleadoService empleadoService;

    // @GetMapping("/ListaReservasPendientes")
    // public List<Reserva> getReservasPendientes(@RequestParam("idUnidad") String idUnidad) {
    //     return reservaScheduler.getReservasPendientes(idUnidad);
    // }



}
