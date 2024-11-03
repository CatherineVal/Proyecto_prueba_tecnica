package com.pruebaTecnica.mva.services;

import com.pruebaTecnica.mva.classes.Cliente;
import com.pruebaTecnica.mva.classes.Cuenta;
import com.pruebaTecnica.mva.classes.Empleado;
import com.pruebaTecnica.mva.repositories.ClienteRepository;
import com.pruebaTecnica.mva.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;

    public ClienteService(){

    }

    public ArrayList<Cliente> geClientes(){
        return (ArrayList)this.clienteRepository.findAll();
    }

    public Optional<Cliente> geCliente(Long id){
        return this.clienteRepository.findById(id);
    }

    public Cliente saveCliente(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Optional<Cliente> findByName(String nombres){
        return this.clienteRepository.findByNombres(nombres);
    }


    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
