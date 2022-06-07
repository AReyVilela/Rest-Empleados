package com.example.apiRest.controller.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpleadoNotFoundException extends RuntimeException {

public EmpleadoNotFoundException (Long id){

    super("No se puede encontrar el Empleado con ID: "+ id);
}


}
