package com.example.apiRest.controller.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Empleado {

    @Id @GeneratedValue
    private Long id;


    private String dni;

    private String nombre;

    private String apellido;

    private int edad;

    private String direccion;

    private int  rol;

    private int salario;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


}
