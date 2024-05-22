package com.feelcondorinc.integraservicios.controllers;

import jakarta.persistence.MappedSuperclass;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.services.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins={"http://localhost:3000"})
@RequestMapping(value="/usuario")
public class UsuarioController {

@Autowired
UsuarioService usuarioservice;
@PostMapping(value="/Login")
public ResponseEntity BananaLogin(@RequestBody Usuario USUARIO) {
    //TODO: process POST request
    System.out.println(USUARIO.getIdUsuario());
    System.out.println(USUARIO.getContrasenia());
    System.out.println(USUARIO.getApellidos());
    Usuario usuariologeado=usuarioservice.Login(USUARIO);
    if(usuariologeado!=null){
        JSONObject mensaje=new JSONObject();
        mensaje.put("rol",usuariologeado.getRolUsuario());
        mensaje.put("nombre",usuariologeado.getNombres());
        mensaje.put("apellido",usuariologeado.getApellidos());
        return new ResponseEntity(mensaje.toString(),HttpStatus.OK);
    }

    
    return new ResponseEntity("Usuario incorrecto",HttpStatus.BAD_REQUEST);
}


}
