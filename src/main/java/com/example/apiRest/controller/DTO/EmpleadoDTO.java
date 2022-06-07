package com.example.apiRest.controller.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Getter @Setter
public class EmpleadoDTO {
    //LO UTILIZO EN LA SPETICIONES GET DE EMPLEADO Y EMPLEADO + id
    private String nombre;
    private String apellido;
    private  String dni;
    private int rol;
}
