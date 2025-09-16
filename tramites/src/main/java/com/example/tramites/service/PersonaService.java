package com.example.tramites.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tramites.exception.PersonaNotFoundException;
import com.example.tramites.model.Persona;
import com.example.tramites.model.Tercero;
import com.example.tramites.repository.PersonaRepository;

@Service
public class PersonaService {

  @Autowired
  private PersonaRepository personaRepository;

  public List<Persona> listarPersonas() {
    return personaRepository.findAll();
  }

  public Optional<Persona> buscarPorId(Long id) {
    return personaRepository.findById(id);
  }

  public Persona crearPersona(Persona persona) {
    return personaRepository.save(persona);
  }

  public void eliminarPersona(Long id) {
    personaRepository.deleteById(id);
  }

  public Persona editarPersona(Long id, Persona personaActualizada) {

    try{
      Optional<Persona> personaExistente = personaRepository.findById(id);
      if (personaExistente.isEmpty()) {
        throw new PersonaNotFoundException(id);
      }
      personaActualizada.setId(id);
      return personaRepository.save(personaActualizada);

    } catch (Exception e) {
      System.err.println("Error al editar la persona: " + id + ": " + e.getMessage());
      throw e;
    }
  }

  public Tercero crearTercero(Tercero tercero) {
    return personaRepository.save(tercero);
  }
  
  public Optional<Tercero> buscarTerceroPorId(Long id) {
    return personaRepository.findById(id)
      .filter(persona -> persona instanceof Tercero)
      .map(persona -> (Tercero) persona);
  }

  public List<Tercero> listarTerceros() {
    return personaRepository.findAll().stream()
      .filter(persona -> persona instanceof Tercero)
      .map(persona -> (Tercero) persona)
      .toList();
  }
}
