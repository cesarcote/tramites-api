package com.example.tramites.dto;

import com.example.tramites.model.Empleado;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class EmpleadoPatchResponse extends PersonaPatchResponse {
  @JsonProperty
  private String dependencia;

  @JsonProperty
  private LocalDate fechaIngreso;

  public EmpleadoPatchResponse(Empleado empleado) {
    super(empleado);
    this.dependencia = empleado.getDependencia();
    this.fechaIngreso = empleado.getFechaIngreso();
  }

  public String getDependencia() {
    return dependencia;
  }

  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }
}