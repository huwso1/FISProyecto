package com.feelcondorinc.integraservicios.controllers;

import java.time.LocalTime;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POJOS.UNIDADPOJO;
import com.feelcondorinc.integraservicios.services.AdminService;
import com.feelcondorinc.integraservicios.services.UsuarioService;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
@RequestMapping(value="/Administracion")
public class AdministracionController {
@Autowired
AdminService adminservice;

@PostMapping(value="/CrearUnidad")
public ResponseEntity crearUnidad(@RequestBody UNIDADPOJO Unidad){
    System.out.println(Unidad.getSabadoi());
    String hola=adminservice.crearUnidad(Unidad);
    JSONObject respuesta=new JSONObject();
    respuesta.put("message",hola);
    if(hola==null){
        return new ResponseEntity(respuesta.toString(),HttpStatus.OK);
    }
    
    return new ResponseEntity(respuesta.toString(),HttpStatus.BAD_REQUEST);

}

}
