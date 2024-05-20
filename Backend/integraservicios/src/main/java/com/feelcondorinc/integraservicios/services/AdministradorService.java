package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private EmpleadosSistemaRepository empleadosSistemaRepository;

    public Usuario createAdministrador(UsuarioRepository usuarioRepository) {

    }

    public Usuario updateAdministrador(Long id) {

    }

    public void deleteAdministrador(Long id) {

    }

}
