package com.example.tramites.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TERCERO")
public class Tercero extends Persona {

  public Tercero() {
    super();
  }

  public Tercero(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos) {
    super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
  }

  @Override
  public String getTipoPersona() {
    return "TERCERO";
  }
}
