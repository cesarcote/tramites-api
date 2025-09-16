package com.example.tramites.exception;

public class TramiteCreationException extends RuntimeException {
  public TramiteCreationException(String message) {
    super(message);
  }

  public TramiteCreationException(String message, Throwable cause) {
    super(message, cause);
  }
}
