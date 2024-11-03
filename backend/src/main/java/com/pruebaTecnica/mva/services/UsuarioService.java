package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Usuario;
import com.pruebaTecnica.mva.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioService() {

    }

    public ArrayList<Usuario> getUsers(){
        return (ArrayList)this.usuarioRepository.findAll();
    }

    public Optional<Usuario> getUser(Long id){
        return this.usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Usuario usuario){
        this.usuarioRepository.delete(usuario);
    }

}
