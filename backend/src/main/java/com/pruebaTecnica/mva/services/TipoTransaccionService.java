package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.TipoTransaccion;
import com.pruebaTecnica.mva.repositories.TipoTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TipoTransaccionService {

    @Autowired
    TipoTransaccionRepository tipoTransaccionRepository;

    public TipoTransaccionService(){

    }

    public ArrayList<TipoTransaccion> getTipoTransaccions(){ return  (ArrayList)this.tipoTransaccionRepository.findAll();}

    public Optional<TipoTransaccion> getTransaccion(Long id){ return this.tipoTransaccionRepository.findById(id);}

}
