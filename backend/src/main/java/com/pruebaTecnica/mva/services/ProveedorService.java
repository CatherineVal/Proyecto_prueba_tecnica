package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Empresa;
import com.pruebaTecnica.mva.classes.Proveedor;
import com.pruebaTecnica.mva.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public ProveedorService(){

    }

    public ArrayList<Proveedor> getProveedors(){
        return (ArrayList)this.proveedorRepository.findAll();
    }

    public Optional<Proveedor> getProveedor(Long id){
        return this.proveedorRepository.findById(id);
    }

    public Proveedor saveProveedor(Proveedor proveedor){

        return this.proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> findByName(String nombre){
        return this.proveedorRepository.findByNombre(nombre);
    }

    public Proveedor updateProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }

}
