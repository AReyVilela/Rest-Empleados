package com.example.apiRest.controller;

import com.example.apiRest.controller.DTO.EmpleadoDTO;
import com.example.apiRest.controller.DTO.EmpleadoDTOConverter;
import com.example.apiRest.controller.excepciones.ApiError;
import com.example.apiRest.controller.excepciones.EmpleadoDuplicado;
import com.example.apiRest.controller.excepciones.EmpleadoNotFoundException;
import com.example.apiRest.controller.excepciones.IdisNull;
import com.example.apiRest.controller.model.Empleado;
import com.example.apiRest.controller.model.EmpleadoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EmpleadosController {

    private final EmpleadoRepositorio empleadoRepositorio;
    private final EmpleadoDTOConverter empleadoDTOConverter;


    @GetMapping("/getEmpleados") //nombre apellido rol dni
    public ResponseEntity<?> getEmpleados() {

        List<Empleado> listaEmpleados = empleadoRepositorio.findAll();

        if (listaEmpleados.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<EmpleadoDTO> dtoList = listaEmpleados.stream().map(empleadoDTOConverter::convertDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/getEmpleadosbyId")
    public Empleado getEmpleadosbyId(@RequestParam(value = "id", required = false) Long id) {
        if(id==null){
            throw new IdisNull();
        }else {
            return empleadoRepositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
        }

    }

    @PutMapping("/putEmpleadosbyId")
    public Empleado modificarEmpleado(@RequestBody Empleado editar, @RequestParam Long id) {
        return empleadoRepositorio.findById(id).map(e -> {
            e.setNombre(editar.getNombre());
            e.setApellido(editar.getApellido());
            e.setDireccion(editar.getDireccion());
            e.setDni(editar.getDni());
            e.setEdad(editar.getEdad());
            e.setRol(editar.getRol());
            e.setSalario(editar.getSalario());
            return empleadoRepositorio.save(e);
        }).orElseThrow(() -> new EmpleadoNotFoundException(id));

    }

    @PostMapping("/postEmpleado")
    public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoDTO nuevo) {
        // Empleado saved= empleadoRepositorio.save(nuevo);
        Optional<Empleado> listaEmpleados = empleadoRepositorio.findByDni(nuevo.getDni());
        if (listaEmpleados.isEmpty()) {
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setNombre(nuevo.getNombre());
            nuevoEmpleado.setApellido(nuevo.getApellido());
            nuevoEmpleado.setRol(nuevo.getRol());
            nuevoEmpleado.setDni(nuevo.getDni());
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoRepositorio.save(nuevoEmpleado));
        } else {
            throw new EmpleadoDuplicado(nuevo.getDni());
        }
    }

    @DeleteMapping("/delEmpleado")
    public ResponseEntity<?> deleteEmpleado(@RequestParam Long id) {
        //   empleadoRepositorio.deleteById(id);
        Empleado empleado = empleadoRepositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
        empleadoRepositorio.delete(empleado);
        return ResponseEntity.noContent().build();
    }

    //EN EL MOMENTO QUE OCURRE UNA EXCEPCION DE ESTE TIPO LA TRATAMOS NOSOTROS PERSONALIZADA
    @ExceptionHandler(EmpleadoNotFoundException.class)
    public ResponseEntity<ApiError> handlerEmpleadoNotFound(EmpleadoNotFoundException ex) {

        ApiError apiError = new ApiError();
        apiError.setEstado(HttpStatus.NOT_FOUND);
        apiError.setFecha(LocalDateTime.now());
        apiError.setMensaje(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(EmpleadoDuplicado.class)
    public ResponseEntity<ApiError> handlerEmpleadoDuplicado(EmpleadoDuplicado ex) {

        ApiError apiError = new ApiError();
        apiError.setEstado(HttpStatus.CONFLICT);
        apiError.setFecha(LocalDateTime.now());
        apiError.setMensaje(ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }
    @ExceptionHandler(IdisNull.class)
    public ResponseEntity<ApiError> handlerIdisNull(IdisNull ex) {

        ApiError apiError = new ApiError();
        apiError.setEstado(HttpStatus.BAD_REQUEST);
        apiError.setFecha(LocalDateTime.now());
        apiError.setMensaje(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

}
