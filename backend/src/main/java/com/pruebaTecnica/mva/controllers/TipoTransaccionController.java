package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.TipoTransaccion;
import com.pruebaTecnica.mva.services.TipoTransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"/api/tipoTransacciones"})
@CrossOrigin(origins = "http://localhost:3000") // Reemplaza esta URL con la URL de tu frontend de ReactJS
public class TipoTransaccionController {

    @Autowired
    TipoTransaccionService tipoTransaccionService;

    public TipoTransaccionController(){

    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<TipoTransaccion> getTipoTransaccions(){
        return this.tipoTransaccionService.getTipoTransaccions();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<TipoTransaccion> getTipoTransaccion(@PathVariable(name = "id")Long id) {
        return  this.tipoTransaccionService.getTransaccion(id);
    }
}
