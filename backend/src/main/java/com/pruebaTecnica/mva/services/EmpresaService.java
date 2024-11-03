package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Banco;
import com.pruebaTecnica.mva.classes.Empresa;
import com.pruebaTecnica.mva.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public EmpresaService(){

    }

    public ArrayList<Empresa> getEmpresas(){ return (ArrayList)this.empresaRepository.findAll();}

    public Optional<Empresa> getEmpresa(Long id){
        return this.empresaRepository.findById(id);
    }

    public Empresa savEmpresa(Empresa empresa){

        return this.empresaRepository.save(empresa);
    }

    public Optional<Empresa> findByName(String nombre){
        return this.empresaRepository.findByNombre(nombre);
    }

    public Empresa updateEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }

}
