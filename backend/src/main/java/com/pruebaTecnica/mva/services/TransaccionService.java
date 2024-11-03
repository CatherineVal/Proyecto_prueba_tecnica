package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Banco;
import com.pruebaTecnica.mva.classes.Transaccion;
import com.pruebaTecnica.mva.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TransaccionService {

    @Autowired
    TransaccionRepository transaccionRepository;

    public TransaccionService(){

    }

    public ArrayList<Transaccion> getTransaccions(){ return (ArrayList)this.transaccionRepository.findAll();}

    public Optional<Transaccion> getTransaccion(Long id){
        return this.transaccionRepository.findById(id);
    }


}
