package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.Cuenta;
import com.pruebaTecnica.mva.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/cuentas"})
@CrossOrigin(origins = "http://localhost:3000")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    public CuentaController(){

    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<Cuenta> geCuentas(){
        return this.cuentaService.geCuentas();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Cuenta> getCuenta(@PathVariable(name= "id") Long id){
        return  this.cuentaService.geCuenta(id);
    }
}
