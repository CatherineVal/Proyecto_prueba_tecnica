package com.pruebaTecnica.mva.repositories;

import com.pruebaTecnica.mva.classes.Banco;
import com.pruebaTecnica.mva.classes.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

    public Optional<Cuenta> findByNumerocuenta(String numerocuenta );
}
