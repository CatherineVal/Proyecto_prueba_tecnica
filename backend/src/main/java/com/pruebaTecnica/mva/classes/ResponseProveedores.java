package com.pruebaTecnica.mva.classes;

import java.util.ArrayList;

public class ResponseProveedores {

    private ArrayList<Proveedor> proveedores;

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public ResponseProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}


