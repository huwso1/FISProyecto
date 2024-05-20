package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.repositories.RecursoRepository;
import org.springframework.stereotype.Service;

@Service
public class RecursoService {
    private RecursoRepository recursoRepository;

    @Autowired

    private final RecursoRepository recursoRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public RecursoService(RecursoRepository recursoRepository, ModelMapper modelMapper) {
        this.recursoRepository = recursoRepository;
        this.modelMapper = modelMapper;
    }

    public RecursoDTO getRecursoById(Long id) {
        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recurso no encontrado con el ID: " + id));
        return convertToDto(recurso);
    }

    public RecursoDTO createRecurso(RecursoDTO recursoDTO) {
        Recurso recurso = convertToEntity(recursoDTO);
        Recurso savedRecurso = recursoRepository.save(recurso);
        return convertToDto(savedRecurso);
    }

    public RecursoDTO updateRecurso(Long id, RecursoDTO recursoDTO) {
        Recurso existingRecurso = recursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recurso no encontrado con el ID: " + id));
        Recurso updatedRecurso = convertToEntity(recursoDTO);
        updatedRecurso.setId(id);
        Recurso savedRecurso = recursoRepository.save(updatedRecurso);
        return convertToDto(savedRecurso);
    }

    public void deleteRecurso(Long id) {
        recursoRepository.deleteById(id);
    }

    private RecursoDTO convertToDto(Recurso recurso) {
        return modelMapper.map(recurso, RecursoDTO.class);
    }

    private Recurso convertToEntity(RecursoDTO recursoDTO) {
        return modelMapper.map(recursoDTO, Recurso.class);
    }
}
