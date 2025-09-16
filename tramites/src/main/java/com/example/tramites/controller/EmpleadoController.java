package com.example.tramites.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.tramites.model.Empleado;
import com.example.tramites.service.EmpleadoService;

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
  public Empleado crearEmpleado(@RequestBody Empleado empleado) {
    return empleadoService.crearEmpleado(empleado);
  }

  @PatchMapping("/{id}")
  public Empleado editarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
    return empleadoService.editarEmpleado(id, empleado);
  }

}
