package com.pruebaTecnica.mva.repositories;

import com.pruebaTecnica.mva.classes.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    public Optional<Empleado> findByNombres(String nombres);
}
