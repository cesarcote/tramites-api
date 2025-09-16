package com.example.tramites.exception;

public class PersonaNotFoundException extends RuntimeException {
  public PersonaNotFoundException(Long id) {
      super("Persona no encontrada con ID: " + id);
  }

  public PersonaNotFoundException(String message) {
      super(message);
  }
}
