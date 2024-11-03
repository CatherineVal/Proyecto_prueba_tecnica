package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Empleado;
import com.pruebaTecnica.mva.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public EmpleadoService(){

    }

    public ArrayList<Empleado> getEmpleados() {
        return (ArrayList)this.empleadoRepository.findAll();
    }

    public Optional<Empleado> getEmpleado(Long id){
        return this.empleadoRepository.findById(id);
    }


    public Empleado saveEmpleado(Empleado empleado){
        return this.empleadoRepository.save(empleado);
    }

    public Optional<Empleado> findByName(String nombre){
        return this.empleadoRepository.findByNombres(nombre);
    }

    public Empleado updateEmpleado(Empleado empleado){
        return this.empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }

}
