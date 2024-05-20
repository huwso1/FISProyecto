package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;

import java.util.List;

public class AfiliadoService {

    private UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Afiliado no encontrado con el ID: " + id));
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario save(Usuario afiliado) {
        return usuarioRepository.save(afiliado);
    }

    public Usuario updateAfiliado(Integer id,Usuario afiliadoActualizado) {
        Usuario afiliado = findById(id); // Busca el afiliado por su ID

        // Actualiza los atributos del afiliado con los nuevos valores proporcionados
        afiliado.setNombres(afiliadoActualizado.getNombres());
        afiliado.setApellidos(afiliadoActualizado.getApellidos());
        afiliado.setNumIdentificacion(afiliadoActualizado.getNumIdentificacion());
        afiliado.setNumContacto(afiliadoActualizado.getNumContacto());

        // Guarda y retorna el afiliado actualizado
        return usuarioRepository.save(afiliado);
    }


    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
