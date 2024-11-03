package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.Transaccion;
import com.pruebaTecnica.mva.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/transacciones"})
public class TransaccionController {
    @Autowired
    TransaccionService transaccionService;

    public TransaccionController(){
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<Transaccion> getTransaccions(){
        return this.transaccionService.getTransaccions();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Transaccion> getTransaccion(@PathVariable(name = "id") Long id){

        return this.transaccionService.getTransaccion(id);
    }
}
