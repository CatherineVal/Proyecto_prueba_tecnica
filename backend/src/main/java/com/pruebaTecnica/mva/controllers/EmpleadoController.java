package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.Empleado;
import com.pruebaTecnica.mva.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/empleados"})
@CrossOrigin(origins = "http://localhost:3000")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    public EmpleadoController(){

    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<Empleado> geEmpleados(){
        return this.empleadoService.getEmpleados();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Empleado> getEmpleado(@PathVariable(name = "id")Long id){
        return this.empleadoService.getEmpleado(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public ResponseEntity<String> saveEmpleado(@RequestBody() Empleado empleado){
        Optional<Empleado> empleadoBusqueda = null;
        Empleado empleadoRes =null;

        empleadoBusqueda = this.empleadoService.findByName(empleado.getNombres());

        if(empleadoBusqueda.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El empleado ya esta registrado");
        }

        empleadoRes = this.empleadoService.saveEmpleado(empleado);

        if(empleadoRes == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Consulta exitosa");

    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> empleadoExistente = empleadoService.getEmpleado(id);

        if (empleadoExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }


        empleado.setIdempleado(id);
        Empleado empleadoActualizado = empleadoService.updateEmpleado(empleado);

        if (empleadoActualizado == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar al empleado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Empleadp actualizado exitosamente");
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable Long id) {
        Optional<Empleado> empleadoExistente = empleadoService.getEmpleado(id);

        if (empleadoExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }

        try {
            empleadoService.deleteEmpleado(id);
            return ResponseEntity.status(HttpStatus.OK).body("Empleado eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar al empleado");
        }
    }


}
