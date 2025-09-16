package com.example.tramites.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("EMPLEADO")
public class Empleado extends Persona {

  @Column(name = "dependencia", nullable = true)
  private String dependencia;

  @Column(name = "fecha_ingreso", nullable = true)
  private LocalDate fechaIngreso;

  public Empleado() {
    super();
  }

  public Empleado(String tipoIdentificacion, String numeroIdentificacion, String nombres, 
                  String apellidos, String dependencia, LocalDate fechaIngreso){
    super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
    this.dependencia = dependencia;
  }

  @Override
  public String getTipoPersona(){
    return "EMPLEADO";
  }

  public String getDependencia() {
    return dependencia;
  }

  public void setDependencia(String dependencia) {
    this.dependencia = dependencia;
  }

  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }
}
