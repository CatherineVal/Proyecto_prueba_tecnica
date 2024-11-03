package com.pruebaTecnica.mva.repositories;

import com.pruebaTecnica.mva.classes.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmpresaRepository  extends CrudRepository<Empresa, Long> {
    public Optional<Empresa> findByNombre(String nombre );
}
