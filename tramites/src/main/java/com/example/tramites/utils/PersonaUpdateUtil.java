package com.example.tramites.utils;

import java.util.Map;
import com.example.tramites.model.Persona;

public class PersonaUpdateUtil {

  public static void updatePersonaFromMap(Persona persona, Map<String, Object> updates) {
    if (updates.containsKey("tipoIdentificacion")) {
      persona.setTipoIdentificacion((String) updates.get("tipoIdentificacion"));
    }
    if (updates.containsKey("numeroIdentificacion")) {
      persona.setNumeroIdentificacion((String) updates.get("numeroIdentificacion"));
    }
    if (updates.containsKey("nombres")) {
      persona.setNombres((String) updates.get("nombres"));
    }
    if (updates.containsKey("apellidos")) {
      persona.setApellidos((String) updates.get("apellidos"));
    }
    if (updates.containsKey("telefono")) {
      persona.setTelefono((String) updates.get("telefono"));
    }
    if (updates.containsKey("direccion")) {
      persona.setDireccion((String) updates.get("direccion"));
    }
    if (updates.containsKey("email")) {
      persona.setEmail((String) updates.get("email"));
    }
  }
}
