package com.example.tramites.utils;

import java.time.LocalDate;
import java.util.Map;
import com.example.tramites.model.Empleado;

public class EmpleadoUpdateUtil {
    
    public static void updateEmpleadoFromMap(Empleado empleado, Map<String, Object> updates) {
        PersonaUpdateUtil.updatePersonaFromMap(empleado, updates);
        if (updates.containsKey("dependencia")) {
            empleado.setDependencia((String) updates.get("dependencia"));
        }
        if (updates.containsKey("fechaIngreso")) {
            empleado.setFechaIngreso(LocalDate.parse((String) updates.get("fechaIngreso")));
        }
    }
}