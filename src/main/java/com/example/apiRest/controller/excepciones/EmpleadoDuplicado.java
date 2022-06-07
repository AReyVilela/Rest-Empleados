package com.example.apiRest.controller.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmpleadoDuplicado extends RuntimeException {


    public EmpleadoDuplicado (String dni){
        super("Ya existe el Empleado con DNI : "+ dni);
    }
}
