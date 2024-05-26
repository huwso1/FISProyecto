package com.feelcondorinc.integraservicios.services;

import com.POJOS.AfiliadoPOJO;
import com.feelcondorinc.integraservicios.entities.Afiliado;
import com.feelcondorinc.integraservicios.entities.models.RolUsuario;
import com.feelcondorinc.integraservicios.repositories.AfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    public void crearAfiliado(AfiliadoPOJO afiliadoPOJO) {
    Afiliado afiliado = new Afiliado();
    afiliado.setIdUsuario(afiliadoPOJO.getIdUsuario());
    afiliado.setContrasenia(afiliadoPOJO.getContrasenia());
    afiliado.setRolUsuario(RolUsuario.AFILIADO); 
    afiliado.setNombres(afiliadoPOJO.getNombres());
    afiliado.setApellidos(afiliadoPOJO.getApellidos());
    afiliado.setNumIdentificacion(afiliadoPOJO.getNumIdentificacion());
    afiliado.setNumContacto(afiliadoPOJO.getNumContacto());
    afiliado.setDireccion(afiliadoPOJO.getDireccion());
    afiliado.setTelefono(afiliadoPOJO.getTelefono());
    afiliado.setEmail(afiliadoPOJO.getEmail());

    afiliadoRepository.save(afiliado);
}

}

