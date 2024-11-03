package com.pruebaTecnica.mva.repositories;

import com.pruebaTecnica.mva.classes.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public Optional<Cliente> findByNombres(String nombres );
}
