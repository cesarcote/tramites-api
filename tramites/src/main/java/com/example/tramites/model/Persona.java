package com.example.tramites.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType  = DiscriminatorType.STRING)
public abstract class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "tipo_identificacion", nullable = false)
  @Pattern(regexp = "CC|CE|TI", message = "El tipo de identificacion debe ser CC, CE o TI")
  private String tipoIdentificacion;

  @Column(name = "numero_identificacion", nullable = false, unique = true)
  @NotBlank(message = "El numero de identificacion no puede estar vacio")
  private String numeroIdentificacion;

  @Column(name = "nombres", nullable = false)
  @NotBlank(message = "Los nombres son obligatorios")
  private String nombres;

  @Column(name = "apellidos", nullable = false)
  @NotBlank(message = "Los apellidos son obligatorios")
  private String apellidos;

  @Column(name = "telefono", nullable = false)
  private String telefono;

  @Column(name = "direccion", nullable = false)
  private String direccion;

  @Column(name = "email", nullable = false)
  @Email(message = "El email debe ser valido")
  private String email;

  public Persona() {}

  public Persona(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos){
    this.tipoIdentificacion = tipoIdentificacion;
    this.numeroIdentificacion = numeroIdentificacion;
    this.nombres = nombres;
    this.apellidos = apellidos;
  }

  public abstract String getTipoPersona();

  public boolean validarEmail(){
    return this.email != null && this.email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTipoIdentificacion() {
    return tipoIdentificacion;
  }

  public void setTipoIdentificacion(String tipoIdentificacion) {
    this.tipoIdentificacion = tipoIdentificacion;
  }

  public String getNumeroIdentificacion() {
    return numeroIdentificacion;
  }

  public void setNumeroIdentificacion(String numeroIdentificacion) {
    this.numeroIdentificacion = numeroIdentificacion;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
