package com.pruebaTecnica.mva.request;

import com.pruebaTecnica.mva.classes.Cuenta;

public class AgregarCliente {

    private String nombres;
    private String apellidos;
    private String correo;
    private String dni;
    private String numerocuenta;
    private Cuenta cuenta;

    public AgregarCliente(){

    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public AgregarCliente(String nombres, String apellidos, String correo, String dni, String numerocuenta, Cuenta cuenta) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.dni = dni;
        this.numerocuenta = numerocuenta;
        this.cuenta = cuenta;
    }
}
