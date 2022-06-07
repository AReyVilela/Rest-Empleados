package com.example.apiRest.controller.model;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface EmpleadoRepositorio extends JpaRepository <Empleado,Long> {


    Optional<Empleado> findByDni(String dni);
}
