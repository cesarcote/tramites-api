package com.example.tramites.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "tramites")
public class Tramite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "numero_radicacion", nullable = false, unique = true)
  private String numeroRadicacion;

  @Column(name = "ano_radicacion", nullable = false)
  private Integer anoRadicacion;

  @Column(name = "nombre_tramite", nullable = false)
  private String nombreTramite;

  @Column(name = "descripcion", nullable = false)
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "empleado_radica_id", nullable = false)
  @NotNull(message = "El empleado que recibe es obligatiorio")
  private Persona personaRadica;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "empleado_recibe_id", nullable = false)
  @NotNull(message = "El empleado que recibe es obligatiorio")
  private Empleado empleadoRecibe;

  @Column(name = "fecha_radicacion", nullable = false, updatable = false)
  private LocalDate fechaRadicacion;

  private static int contador = 1;

  public Tramite() {
    this.fechaRadicacion = LocalDate.now();
    this.anoRadicacion = this.fechaRadicacion.getYear();
  }

  public Tramite(String nombreTramite, String descripcion, Persona personaRadica, Empleado empleadoRecibe) {
    this();
    this.nombreTramite = nombreTramite;
    this.descripcion = descripcion;
    this.personaRadica = personaRadica;
    this.empleadoRecibe = empleadoRecibe;
    this.numeroRadicacion = generarNumeroRadicacion();
  }

  private String generarNumeroRadicacion(){
    return String.format("%04d-%06d", this.anoRadicacion, contador++);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumeroRadicacion() {
    return numeroRadicacion;
  }

  public void setNumeroRadicacion(String numeroRadicacion) {
    this.numeroRadicacion = numeroRadicacion;
  }

  public Integer getAnoRadicacion() {
    return anoRadicacion;
  }

  public void setAnoRadicacion(Integer anoRadicacion) {
    this.anoRadicacion = anoRadicacion;
  }

  public String getNombreTramite() {
    return nombreTramite;
  }

  public void setNombreTramite(String nombreTramite) {
    this.nombreTramite = nombreTramite;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Persona getPersonaRadica() {
    return personaRadica;
  }

  public void setPersonaRadica(Persona personaRadica) {
    this.personaRadica = personaRadica;
  }

  public Empleado getEmpleadoRecibe() {
    return empleadoRecibe;
  }

  public void setEmpleadoRecibe(Empleado empleadoRecibe) {
    this.empleadoRecibe = empleadoRecibe;
  }

  public LocalDate getFechaRadicacion() {
    return fechaRadicacion;
  }

  public void setFechaRadicacion(LocalDate fechaRadicacion) {
    this.fechaRadicacion = fechaRadicacion;
  }
}
