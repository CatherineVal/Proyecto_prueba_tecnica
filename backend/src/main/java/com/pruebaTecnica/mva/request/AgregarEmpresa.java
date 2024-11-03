package com.pruebaTecnica.mva.request;

import com.pruebaTecnica.mva.classes.Cuenta;
import com.pruebaTecnica.mva.classes.Usuario;

public class AgregarEmpresa {

    private String nombre;
    private String descripcion;
    private Cuenta cuenta;
    private Usuario usuario;


    public AgregarEmpresa(){

    }

    @Override
    public String toString() {
        return "AgregarEmpresa{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cuenta=" + cuenta +
                ", usuario=" + usuario +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AgregarEmpresa(String nombre, String descripcion, Cuenta cuenta, Usuario usuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cuenta = cuenta;
        this.usuario = usuario;
    }
}
