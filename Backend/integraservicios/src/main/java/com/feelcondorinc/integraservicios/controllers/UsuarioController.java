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

import com.POJOS.AfiliadoPOJO;
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
    JSONObject mensaje=new JSONObject();
    if(usuariologeado!=null){
        
        mensaje.put("message","Login exitoso");
        mensaje.put("rol",usuariologeado.getRolUsuario());
        mensaje.put("nombre",usuariologeado.getNombres());
        mensaje.put("apellido",usuariologeado.getApellidos());
        return new ResponseEntity(mensaje.toString(),HttpStatus.OK);
    }
        mensaje.put("message","Usuario o contraseña incorrectos");
    
    return new ResponseEntity(mensaje.toString(),HttpStatus.BAD_REQUEST);
}

@Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/CrearAfiliado")
public ResponseEntity<String> crearAfiliado(@RequestBody AfiliadoPOJO afiliadoPOJO) {
    String mensaje = usuarioService.crearAfiliado(afiliadoPOJO);
    return new ResponseEntity<>(mensaje, HttpStatus.OK);
}

}
