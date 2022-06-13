package com.example.apiRest.controller.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdisNull extends RuntimeException{

    public IdisNull (){
        super("Id es nulo o vacío");
    }
}
