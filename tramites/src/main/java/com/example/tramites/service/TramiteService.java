package com.example.tramites.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tramites.exception.EmpleadoNotFoundException;
import com.example.tramites.exception.PersonaNotFoundException;
import com.example.tramites.exception.TramiteCreationException;
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

    try {
      Optional<Persona> persona = personaRepository.findById(personaId);
      Optional<Empleado> empleado = empleadoRepository.findById(empleadoId);
  
      if (persona.isEmpty()) {
        throw new PersonaNotFoundException(personaId);
      }
      
      if (empleado.isEmpty()) {
        throw new EmpleadoNotFoundException(empleadoId);
      }

      Tramite tramite = new Tramite(
        nombreTramite,
        description,
        persona.get(),
        empleado.get()
      );

      return tramiteRepository.save(tramite);
    } catch (PersonaNotFoundException | EmpleadoNotFoundException e) {
      throw e;

    } catch (Exception e) {
      System.err.println("Error al crear el trámite: " + e.getMessage());
      throw new TramiteCreationException("Error al crear el trámite: " + e.getMessage(), e);
    }
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
}
