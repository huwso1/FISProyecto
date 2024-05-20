package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.Usuario;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return convertToDto(usuario);
    }

    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return convertToDto(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para convertir de UsuarioDTO a Usuario
    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
        //
        return usuario;
    }

    // Método para convertir de Usuario a UsuarioDTO
    private UsuarioDTO convertToDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getIdUsuario());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setCorreoElectronico(usuario.getCorreoElectronico());
        //
        return usuarioDTO;
    }
}
