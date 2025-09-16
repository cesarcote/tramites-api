package com.example.tramites.dto;

import com.example.tramites.model.Persona;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaPatchResponse {
    @JsonProperty
    private Long id;
    
    @JsonProperty
    private String tipoIdentificacion;
    
    @JsonProperty
    private String numeroIdentificacion;
    
    @JsonProperty
    private String nombres;
    
    @JsonProperty
    private String apellidos;
    
    @JsonProperty
    private String telefono;
    
    @JsonProperty
    private String direccion;
    
    @JsonProperty
    private String email;
    
    @JsonProperty
    private String tipoPersona;

    public PersonaPatchResponse(Persona persona) {
        this.id = persona.getId();
        this.tipoIdentificacion = persona.getTipoIdentificacion();
        this.numeroIdentificacion = persona.getNumeroIdentificacion();
        this.nombres = persona.getNombres();
        this.apellidos = persona.getApellidos();
        this.telefono = persona.getTelefono();
        this.direccion = persona.getDireccion();
        this.email = persona.getEmail();
        this.tipoPersona = persona.getTipoPersona();
    }

    public Long getId() {
        return id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }
}