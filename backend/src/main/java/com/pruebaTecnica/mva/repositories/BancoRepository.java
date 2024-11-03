package com.pruebaTecnica.mva.repositories;

import com.pruebaTecnica.mva.classes.Banco;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BancoRepository  extends CrudRepository <Banco, Long> {

    public Optional<Banco> findByNombre(String nombre );
}
