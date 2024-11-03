package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.TipoCuenta;
import com.pruebaTecnica.mva.repositories.TipoCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TipoCuentaService {

    @Autowired
    TipoCuentaRepository tipoCuentaRepository;

    public TipoCuentaService(){

    }


    public ArrayList<TipoCuenta> geTipoCuentas(){
        return (ArrayList)this.tipoCuentaRepository.findAll();
    }


    public Optional<TipoCuenta> getTipoCuenta(Long id){
        return  this.tipoCuentaRepository.findById(id);
    }
}
