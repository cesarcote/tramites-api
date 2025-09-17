package com.example.tramites.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tramites.model.Persona;
import com.example.tramites.model.Tercero;
import com.example.tramites.service.PersonaService;
import com.example.tramites.dto.PersonaPatchResponse;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

  @Autowired
  private PersonaService personaService;

  @GetMapping
  public List<Persona> listarPersonas() {
    return personaService.listarPersonas();
  }

  @GetMapping("/{id}")
  public Optional<Persona> obtenerPersonaPorId(@PathVariable Long id) {
    return personaService.buscarPorId(id);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<PersonaPatchResponse> editarPersona(@PathVariable Long id,
      @RequestBody Map<String, Object> updates) {
    Persona personaActualizada = personaService.editarPersonaParcial(id, updates);
    return ResponseEntity.ok(new PersonaPatchResponse(personaActualizada));
  }

  @PostMapping("/terceros")
  public Tercero crearTercero(@RequestBody Tercero tercero) {
    return (Tercero) personaService.crearPersona(tercero);
  }

  @GetMapping("/terceros/{id}")
  public Optional<Tercero> buscarTerceroPorId(@PathVariable Long id) {
    return personaService.buscarTerceroPorId(id);
  }
}