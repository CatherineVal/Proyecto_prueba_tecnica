package com.pruebaTecnica.mva.classes;

import java.util.ArrayList;
import java.util.Optional;

public class ResponseProveedor {

    private Optional<Proveedor> proveedor;


    public Optional<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(Optional<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    public ResponseProveedor(Optional<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }
}
