package com.pruebaTecnica.mva.controllers;

import com.pruebaTecnica.mva.classes.Response;
import com.pruebaTecnica.mva.classes.Usuario;
import com.pruebaTecnica.mva.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/api/usuarios"})
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    public UsuarioController() {
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ArrayList<Usuario>  getUsers() {

        //Response consultaExitosa = new Response("CONSULTA EXITOSA", "0000", null);

        //return consultaExitosa;

        return this.usuarioService.getUsers();
    }

    @CrossOrigin(origins = "*")
    @GetMapping({"/{id}"})
    public Optional<Usuario> getUser(@PathVariable(name = "id") Long id) {

        //Response consultaExitosa = new Response("CONSULTA EXITOSA", "0000", null);

        //return consultaExitosa;

        return this.usuarioService.getUser(id);
    }


}
