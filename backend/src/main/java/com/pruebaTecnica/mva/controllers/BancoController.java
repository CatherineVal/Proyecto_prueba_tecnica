package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.Banco;
import com.pruebaTecnica.mva.classes.Response;
import com.pruebaTecnica.mva.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/bancos"})
public class BancoController {
    @Autowired
    BancoService bancoService;

    public BancoController(){

    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<Banco> getBancos(){

        return this.bancoService.getBanks();
    }
    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Banco> getBanco(@PathVariable(name = "id") Long id){

        return this.bancoService.getBank(id);
    }
    @CrossOrigin(origins = "*")
    @PostMapping()
    public ResponseEntity<String> saveBanco(@RequestBody() Banco banco) {

        Optional<Banco> bancoBusqueda = null;
        Banco bancoRes = null;

        bancoBusqueda = this.bancoService.findByName(banco.getNombre());

        if (bancoBusqueda.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El banco ya esta registrado");
        }

        bancoRes = this.bancoService.saveBank(banco);

        if (bancoRes == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un problema");
        }

        return  ResponseEntity.status(HttpStatus.CREATED).body("Consulta exitosa" );

    }
}
