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
  private Integer nombreTramite;

  @Column(name = "descripcion", nullable = false)
  private Integer descripcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "funcionario_radica_id", nullable = false)
  @NotNull(message = "El funcionario que recibe es obligatiorio")
  private Persona personaRadica;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "funcionario_recibe_id", nullable = false)
  @NotNull(message = "El funcionario que recibe es obligatiorio")
  private Empleado funcionarioRecibe;

  @Column(name = "fecha_radicacion", nullable = false, updatable = false)
  private LocalDate fechaRadicacion;

  public Tramite() {
    this.fechaRadicacion = LocalDate.now();
    this.anoRadicacion = this.fechaRadicacion.getYear();
  }

  public Tramite(Integer nombreTramite, Integer descripcion, Empleado personaRadica, Empleado funcionarioRecibe){
    this();
    this.nombreTramite = nombreTramite;
    this.descripcion = descripcion;
    this.personaRadica = personaRadica;
    this.funcionarioRecibe = funcionarioRecibe;
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

  public Integer getNombreTramite() {
    return nombreTramite;
  }

  public void setNombreTramite(Integer nombreTramite) {
    this.nombreTramite = nombreTramite;
  }

  public Integer getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(Integer descripcion) {
    this.descripcion = descripcion;
  }

  public Persona getPersonaRadica() {
    return personaRadica;
  }

  public void setPersonaRadica(Persona personaRadica) {
    this.personaRadica = personaRadica;
  }

  public Empleado getFuncionarioRecibe() {
    return funcionarioRecibe;
  }

  public void setFuncionarioRecibe(Empleado funcionarioRecibe) {
    this.funcionarioRecibe = funcionarioRecibe;
  }

  public LocalDate getFechaRadicacion() {
    return fechaRadicacion;
  }

  public void setFechaRadicacion(LocalDate fechaRadicacion) {
    this.fechaRadicacion = fechaRadicacion;
  }
}
