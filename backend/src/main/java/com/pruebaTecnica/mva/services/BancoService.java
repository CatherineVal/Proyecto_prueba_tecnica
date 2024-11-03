package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Banco;
import com.pruebaTecnica.mva.repositories.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    BancoRepository bancoRepository;

    public BancoService(){

    }

    public ArrayList<Banco> getBanks(){
        return (ArrayList)this.bancoRepository.findAll();
    }

    public Optional<Banco> getBank(Long id){
        return this.bancoRepository.findById(id);
    }


    public Banco saveBank(Banco banco){
        return this.bancoRepository.save(banco);
    }


    public Optional<Banco> findByName(String nombre){
        return this.bancoRepository.findByNombre(nombre);
    }

}
