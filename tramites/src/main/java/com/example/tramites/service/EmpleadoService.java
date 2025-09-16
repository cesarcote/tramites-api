package com.example.tramites.service;

import com.example.tramites.model.Empleado;
import com.example.tramites.repository.EmpleadoRepository;
import com.example.tramites.utils.EmpleadoUpdateUtil;
import com.example.tramites.exception.EmpleadoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmpleadoService {

  @Autowired
  private EmpleadoRepository empleadoRepository;

  public Empleado crearEmpleado(Empleado empleado) {
    return empleadoRepository.save(empleado);
  }

  public List<Empleado> listarEmpleados() {
    return empleadoRepository.findAll();
  }

  public Optional<Empleado> buscarPorId(Long id) {
    return empleadoRepository.findById(id);
  }

  public void eliminarEmpleado(Long id) {
    empleadoRepository.deleteById(id);
  }

  public Empleado editarEmpleadoParcial(Long id, Map<String, Object> updates) {
    Empleado empleado = empleadoRepository.findById(id)
        .orElseThrow(() -> new EmpleadoNotFoundException(id));

    EmpleadoUpdateUtil.updateEmpleadoFromMap(empleado, updates);
    return empleadoRepository.save(empleado);
  }
}
