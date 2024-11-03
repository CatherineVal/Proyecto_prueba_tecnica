package com.pruebaTecnica.mva.repositories;

import com.pruebaTecnica.mva.classes.Empresa;
import com.pruebaTecnica.mva.classes.Proveedor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {
    public Optional<Proveedor> findByNombre(String nombre );
}
