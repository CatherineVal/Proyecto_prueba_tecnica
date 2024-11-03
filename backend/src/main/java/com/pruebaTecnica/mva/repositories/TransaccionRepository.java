package com.pruebaTecnica.mva.repositories;

import com.pruebaTecnica.mva.classes.Transaccion;
import org.springframework.data.repository.CrudRepository;

public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
}
