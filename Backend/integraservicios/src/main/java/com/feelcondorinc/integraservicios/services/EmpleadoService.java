package com.feelcondorinc.integraservicios.services;

public class EmpleadoService {

    @Autowired

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public EmpleadoDTO getEmpleadoById(Long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            return convertToDto(empleado);
        } else {
            throw new IllegalArgumentException("Empleado no encontrado con el ID: " + id);
        }
    }

    public List<EmpleadoDTO> getAllEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = convertToEntity(empleadoDTO);
        Empleado savedEmpleado = empleadoRepository.save(empleado);
        return convertToDto(savedEmpleado);
    }

    public EmpleadoDTO updateEmpleado(Long id, EmpleadoDTO empleadoDTO) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleadoToUpdate = empleadoOptional.get();
            // Actualizar los campos del empleadoToUpdate con los datos del empleadoDTO
            // Implementar la lógica específica para actualizar los campos necesarios
            Empleado updatedEmpleado = empleadoRepository.save(empleadoToUpdate);
            return convertToDto(updatedEmpleado);
        } else {
            throw new IllegalArgumentException("Empleado no encontrado con el ID: " + id);
        }
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

    // Método para convertir de Empleado a EmpleadoDTO
    private EmpleadoDTO convertToDto(Empleado empleado) {
        return new EmpleadoDTO(empleado.getId(), empleado.getNombre(), empleado.getCorreoElectronico());
    }

    // Método para convertir de EmpleadoDTO a Empleado
    private Empleado convertToEntity(EmpleadoDTO empleadoDTO) {
        return new Empleado(empleadoDTO.getId(), empleadoDTO.getNombre(), empleadoDTO.getCorreoElectronico());
    }
}
