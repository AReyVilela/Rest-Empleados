package com.example.apiRest.controller.DTO;

import com.example.apiRest.controller.model.Empleado;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmpleadoDTOConverter{

    private final ModelMapper modelMapper;

    public EmpleadoDTO convertDTO(Empleado empleado){

        return modelMapper.map(empleado,EmpleadoDTO.class);
    }

}

