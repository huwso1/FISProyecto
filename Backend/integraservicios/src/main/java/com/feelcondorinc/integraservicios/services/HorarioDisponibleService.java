package com.feelcondorinc.integraservicios.services;

import com.feelcondorinc.integraservicios.entities.HorarioDisponible;
import com.feelcondorinc.integraservicios.repositories.HorarioDisponibleRepository;
import org.springframework.stereotype.Service;

@Service
public class HorarioDisponibleService {

    private HorarioDisponibleRepository horarioDisponibleRepository;

    @Autowired

    private final HorarioDisponibilidadRepository horarioDisponibilidadRepository;

    @Autowired
    public HorarioDisponibilidadService(HorarioDisponibilidadRepository horarioDisponibilidadRepository) {
        this.horarioDisponibilidadRepository = horarioDisponibilidadRepository;
    }

    public HorarioDisponibilidadDTO getHorarioDisponibilidadById(Long id) {
        Optional<HorarioDisponibilidad> horarioDisponibilidadOptional = horarioDisponibilidadRepository.findById(id);
        if (horarioDisponibilidadOptional.isPresent()) {
            return convertToDTO(horarioDisponibilidadOptional.get());
        } else {
            return null;
        }
    }

    public List<HorarioDisponibilidadDTO> getAllHorariosDisponibilidad() {
        List<HorarioDisponibilidad> horarios = horarioDisponibilidadRepository.findAll();
        return horarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public HorarioDisponibilidadDTO createHorarioDisponibilidad(HorarioDisponibilidadDTO horarioDisponibilidadDTO) {
        HorarioDisponibilidad horarioDisponibilidad = convertToEntity(horarioDisponibilidadDTO);
        HorarioDisponibilidad savedHorario = horarioDisponibilidadRepository.save(horarioDisponibilidad);
        return convertToDTO(savedHorario);
    }

    public HorarioDisponibilidadDTO updateHorarioDisponibilidad(Long id, HorarioDisponibilidadDTO horarioDisponibilidadDTO) {
        Optional<HorarioDisponibilidad> existingHorarioOptional = horarioDisponibilidadRepository.findById(id);
        if (existingHorarioOptional.isPresent()) {
            HorarioDisponibilidad existingHorario = existingHorarioOptional.get();
            // Actualiza los campos del horario existente con los valores del DTO
            existingHorario.setFechaInicio(horarioDisponibilidadDTO.getFechaInicio());
            existingHorario.setFechaFin(horarioDisponibilidadDTO.getFechaFin());
            existingHorario.setHorarioDiario(convertHorariosDTOToModel(horarioDisponibilidadDTO.getHorarioDiario()));
            existingHorario.setEstado(convertEstadoDTOToModel(horarioDisponibilidadDTO.getEstado()));
            HorarioDisponibilidad updatedHorario = horarioDisponibilidadRepository.save(existingHorario);
            return convertToDTO(updatedHorario);
        } else {
            return null;
        }
    }

    public void deleteHorarioDisponibilidad(Long id) {
        horarioDisponibilidadRepository.deleteById(id);
    }

    private HorarioDisponibilidadDTO convertToDTO(HorarioDisponibilidad horarioDisponibilidad) {
        HorarioDisponibilidadDTO dto = new HorarioDisponibilidadDTO();
        dto.setIdRecurso(horarioDisponibilidad.getIdElemento());
        dto.setFechaInicio(horarioDisponibilidad.getFechaInicio());
        dto.setFechaFin(horarioDisponibilidad.getFechaFin());
        dto.setHorarioDiario(convertHorariosModelToDTO(horarioDisponibilidad.getHorarioDiario()));
        dto.setEstado(convertEstadoModelToDTO(horarioDisponibilidad.getEstado()));
        return dto;
    }

    private HorarioDisponibilidad convertToEntity(HorarioDisponibilidadDTO dto) {
        HorarioDisponibilidad horarioDisponibilidad = new HorarioDisponibilidad();
        horarioDisponibilidad.setIdElemento(dto.getIdRecurso());
        horarioDisponibilidad.setFechaInicio(dto.getFechaInicio());
        horarioDisponibilidad.setFechaFin(dto.getFechaFin());
        horarioDisponibilidad.setHorarioDiario(convertHorariosDTOToModel(dto.getHorarioDiario()));
        horarioDisponibilidad.setEstado(convertEstadoDTOToModel(dto.getEstado()));
        return horarioDisponibilidad;
    }

    private List<HorarioDTO> convertHorariosModelToDTO(List<Horario> horarios) {
        return horarios.stream()
                .map(horario -> new HorarioDTO(
                        horario.getHoraInicio(),
                        horario.getHoraFin(),
                        horario.getMinutoInicio(),
                        horario.getMinutoFin()))
                .collect(Collectors.toList());
    }

    private List<Horario> convertHorariosDTOToModel(List<HorarioDTO> horariosDTO) {
        return horariosDTO.stream()
                .map(horarioDTO -> new Horario(
                        horarioDTO.getHoraInicio(),
                        horarioDTO.getHoraFin(),
                        horarioDTO.getMinutoInicio(),
                        horarioDTO.getMinutoFin()))
                .collect(Collectors.toList());
    }

    private EstadoRecursoDTO convertEstadoModelToDTO(EstadoRecurso estado) {
        return new EstadoRecursoDTO(estado.getId(), estado.getDiaSemana());
    }

    private EstadoRecurso convertEstadoDTOToModel(EstadoRecursoDTO estadoDTO) {
        return new EstadoRecurso(estadoDTO.getId(), estadoDTO.getDiaSemana());
    }
}
