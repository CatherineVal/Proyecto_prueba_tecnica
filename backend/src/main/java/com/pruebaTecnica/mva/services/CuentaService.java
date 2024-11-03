package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Cuenta;
import com.pruebaTecnica.mva.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CuentaService {


    @Autowired
    CuentaRepository cuentaRepository;

    public CuentaService(){

    }

    public ArrayList<Cuenta> geCuentas(){ return (ArrayList)this.cuentaRepository.findAll();}

    public Optional<Cuenta> geCuenta(Long id){
        return this.cuentaRepository.findById(id);
    }

    public Optional<Cuenta> getNumCuenta(String numero){
        return this.cuentaRepository.findByNumerocuenta(numero);
    }

    public  Cuenta saveCuenta (Cuenta cuenta){
        return this.cuentaRepository.save(cuenta);
    }

    public void deleteCuenta (Cuenta cuenta){
        this.cuentaRepository.delete(cuenta);
    }

}
