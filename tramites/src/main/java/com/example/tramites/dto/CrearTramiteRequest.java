package com.example.tramites.dto;

public class CrearTramiteRequest {
  private String nombreTramite;
  private String descripcion;
  private Long personaRadicaId;
  private Long funcionarioRecibeId;

  public CrearTramiteRequest() {
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

  public Long getPersonaRadicaId() {
    return personaRadicaId;
  }

  public void setPersonaRadicaId(Long personaRadicaId) {
    this.personaRadicaId = personaRadicaId;
  }

  public Long getFuncionarioRecibeId() {
    return funcionarioRecibeId;
  }

  public void setFuncionarioRecibeId(Long funcionarioRecibeId) {
    this.funcionarioRecibeId = funcionarioRecibeId;
  }
}

