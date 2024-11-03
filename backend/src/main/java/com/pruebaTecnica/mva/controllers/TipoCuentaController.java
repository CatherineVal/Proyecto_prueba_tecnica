package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.TipoCuenta;
import com.pruebaTecnica.mva.services.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/tipocuenta"})
public class TipoCuentaController {

    @Autowired
    TipoCuentaService tipoCuentaService;

    public TipoCuentaController(){

    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<TipoCuenta> getTipoCuentas(){
        return this.tipoCuentaService.geTipoCuentas();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<TipoCuenta> getTipoCuenta(@PathVariable(name = "id") Long id){
        return this.tipoCuentaService.getTipoCuenta(id);
    }
}
