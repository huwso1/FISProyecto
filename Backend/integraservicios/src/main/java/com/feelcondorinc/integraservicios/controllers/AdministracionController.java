package com.feelcondorinc.integraservicios.controllers;

import java.time.LocalTime;
import java.util.ArrayList;
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

import com.POJOS.EMPLEADOPOJO;
import com.POJOS.RECURSOPOJO;
import com.POJOS.UNIDADPOJO;
import com.feelcondorinc.integraservicios.entities.Recurso;
import com.feelcondorinc.integraservicios.entities.Unidad;
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

@PostMapping(value="/CrearRecurso")
public ResponseEntity crearRecurso(@RequestBody RECURSOPOJO Recurso){
    
    String hola=adminservice.crearRecurso(Recurso);
    JSONObject respuesta=new JSONObject();
    respuesta.put("message",hola);
    if(hola==null){
        return new ResponseEntity(respuesta.toString(),HttpStatus.OK);
    }
    
    
    return new ResponseEntity("banana",HttpStatus.BAD_REQUEST);

}
@PostMapping(value="/Unidades")
public ResponseEntity<List<Unidad>> consultarUnidades(@RequestBody String body){
    
    List<Unidad> Listaunidades=adminservice.consultarUnidades();
    if(Listaunidades!=null){
        return new ResponseEntity(Listaunidades,HttpStatus.OK);  
    }
    
    return new ResponseEntity("{ \"message\":\"salio mal\"}",HttpStatus.BAD_REQUEST);

}

@PostMapping(value="/CrearEmpleado")
public ResponseEntity crearEmpleado(@RequestBody EMPLEADOPOJO Empleado){
    
    String mensaje=adminservice.crearEmpleado(Empleado);
    if(mensaje==null){
        
        return new ResponseEntity(mensaje,HttpStatus.OK);  
    }
    JSONObject message=new JSONObject();
        message.put("message",mensaje);
    return new ResponseEntity(message.toString(),HttpStatus.BAD_REQUEST);

}

@PostMapping(value="/Recursos")
public ResponseEntity<List<Unidad>> consultarRecursos(@RequestBody String body){
    JSONObject request=new JSONObject(body);
    List<Recurso> Listarecursos=adminservice.consultarRecursoPorUnidad(request.getString("idUnidad"));
    if(Listarecursos!=null){
        return new ResponseEntity(Listarecursos,HttpStatus.OK);  
    }
    
    return new ResponseEntity("{ \"message\":\"salio mal\"}",HttpStatus.BAD_REQUEST);

}

}
