package com.example.tramites.exception;

public class EmpleadoNotFoundException extends RuntimeException {
  public EmpleadoNotFoundException(Long id) {
      super("Empleado no encontrada con ID: " + id);
  }

  public EmpleadoNotFoundException(String message) {
      super(message);
  }
}
