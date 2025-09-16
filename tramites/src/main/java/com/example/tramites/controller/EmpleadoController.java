package com.example.tramites.controller;

import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tramites.model.Empleado;
import com.example.tramites.service.EmpleadoService;
import com.example.tramites.dto.EmpleadoPatchResponse;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

  @Autowired
  private EmpleadoService empleadoService;

  @GetMapping
  public List<Empleado> listarEmpleados() {
    return empleadoService.listarEmpleados();
  }

  @GetMapping("/{id}")
  public Optional<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
    return empleadoService.buscarPorId(id);
  }

  @PostMapping
  public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
    Empleado nuevoEmpleado = empleadoService.crearEmpleado(empleado);
    return ResponseEntity.ok(nuevoEmpleado);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<EmpleadoPatchResponse> editarEmpleado(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    Empleado empleadoActualizado = empleadoService.editarEmpleadoParcial(id, updates);
    return ResponseEntity.ok(new EmpleadoPatchResponse(empleadoActualizado));
  }

}