package com.example.tramites.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.tramites.dto.CrearTramiteRequest;
import com.example.tramites.model.Tramite;
import com.example.tramites.service.TramiteService;

@RestController
@RequestMapping("/api/tramites")
public class TramiteController {

  @Autowired
  private TramiteService tramiteService;

  @GetMapping
  public List<Tramite> listarTramites() {
    return tramiteService.listarTramites();
  }

  @GetMapping("/{id}")
  public Optional<Tramite> obtenerTramitePorId(@PathVariable Long id) {
    return tramiteService.buscarPorId(id);
  }

  @PostMapping
  public Tramite crearTramite(@RequestBody CrearTramiteRequest request) {
    return tramiteService.crearTramite(request.getNombreTramite(),
        request.getDescripcion(), 
        request.getPersonaRadicaId(),
        request.getFuncionarioRecibeId());
  }
}
