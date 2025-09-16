package com.example.tramites.service;

import com.example.tramites.model.Empleado;
import com.example.tramites.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

  public Empleado editarEmpleado(Long id, Empleado empleadoActualizado) {

    try{
      Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);
      if (empleadoExistente.isEmpty()) {
        throw new RuntimeException("Empleado no encontrado con ID: " + id);
      }
      empleadoActualizado.setId(id);
      return empleadoRepository.save(empleadoActualizado);

    } catch (Exception e) {
      System.err.println("Error al editar el empleado: " + id + ": " + e.getMessage());
      throw e;
    }
  }
}
