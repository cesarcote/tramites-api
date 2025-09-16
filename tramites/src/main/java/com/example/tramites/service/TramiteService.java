package com.example.tramites.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tramites.model.Empleado;
import com.example.tramites.model.Persona;
import com.example.tramites.model.Tramite;
import com.example.tramites.repository.EmpleadoRepository;
import com.example.tramites.repository.PersonaRepository;
import com.example.tramites.repository.TramiteRepository;

@Service
public class TramiteService {

  @Autowired
  private TramiteRepository tramiteRepository;

  @Autowired
  private PersonaRepository personaRepository;
  
  @Autowired
  private EmpleadoRepository empleadoRepository;

  public Tramite crearTramite(String nombreTramite, String description, Long personaId, Long empleadoId) { 

    Optional<Persona> persona = personaRepository.findById(personaId);
    Optional<Empleado> empleado = empleadoRepository.findById(empleadoId);

    if (persona.isEmpty() || empleado.isEmpty()){
      throw new RuntimeException("Persona o empleado no encontrado");
    }

    Tramite tramite = new Tramite(
      nombreTramite,
      description,
      persona.get(),
      empleado.get()
    );

    return tramiteRepository.save(tramite);
  }

  public List<Tramite> listarTramites() {
    return tramiteRepository.findAll();
  }

  public Optional<Tramite> buscarPorId(Long id) {
    return tramiteRepository.findById(id);
  }

  public void eliminarTramite(Long id) {
    tramiteRepository.deleteById(id);
  }

  public List<Persona> listarPersonas() {
    return personaRepository.findAll();
  }

  public List<Empleado> listarEmpleados() {
    return empleadoRepository.findAll();
  }

  public Persona crearPersona(Persona persona) {
    return personaRepository.save(persona);
  }

  public Empleado crearEmpleado(Empleado empleado) {
    return empleadoRepository.save(empleado);
  }

}
