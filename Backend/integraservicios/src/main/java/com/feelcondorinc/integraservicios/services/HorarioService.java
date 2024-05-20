package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.repositories.HorarioRepository;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    private HorarioRepository horarioRepository;

    @Autowired

    private final HorarioRepository horarioRepository;

    @Autowired
    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public HorarioDTO findById(Long id) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Horario no encontrado con el ID: " + id));
        return convertToDto(horario);
    }

    public List<HorarioDTO> findAll() {
        return horarioRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public HorarioDTO save(HorarioDTO horarioDTO) {
        Horario horario = convertToEntity(horarioDTO);
        Horario savedHorario = horarioRepository.save(horario);
        return convertToDto(savedHorario);
    }

    public HorarioDTO update(Long id, HorarioDTO horarioDTO) {
        Optional<Horario> optionalHorario = horarioRepository.findById(id);
        if (optionalHorario.isPresent()) {
            Horario horario = optionalHorario.get();
            horario.setHoraInicio(horarioDTO.getHoraInicio());
            horario.setHoraFin(horarioDTO.getHoraFin());
            horario.setMinutoInicio(horarioDTO.getMinutoInicio());
            horario.setMinutoFin(horarioDTO.getMinutoFin());
            Horario updatedHorario = horarioRepository.save(horario);
            return convertToDto(updatedHorario);
        } else {
            throw new IllegalArgumentException("Horario no encontrado con el ID: " + id);
        }
    }

    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }

    private HorarioDTO convertToDto(Horario horario) {
        return new HorarioDTO(horario.getHoraInicio(), horario.getHoraFin(), horario.getMinutoInicio(), horario.getMinutoFin());
    }

    private Horario convertToEntity(HorarioDTO horarioDTO) {
        return new Horario(horarioDTO.getHoraInicio(), horarioDTO.getHoraFin(), horarioDTO.getMinutoInicio(), horarioDTO.getMinutoFin());
    }
}
