package com.pruebaTecnica.mva.request;

import com.pruebaTecnica.mva.classes.Cuenta;
import com.pruebaTecnica.mva.classes.Empresa;
import com.pruebaTecnica.mva.classes.Usuario;

public class AgregarProveedores {

    private String nombre;
    private String departamento;
    private Long idtipocuenta;

    private String numerocuenta;

    private String moneda;
    private Float saldo;
    private Long idempresa;
    private String rubro;

    public AgregarProveedores(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Long getIdtipocuenta() {
        return idtipocuenta;
    }

    public void setIdtipocuenta(Long idtipocuenta) {
        this.idtipocuenta = idtipocuenta;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public AgregarProveedores(String nombre, String departamento, Long idtipocuenta, String numerocuenta, String moneda, Float saldo, Long idempresa, String rubro) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.idtipocuenta = idtipocuenta;
        this.numerocuenta = numerocuenta;
        this.moneda = moneda;
        this.saldo = saldo;
        this.idempresa = idempresa;
        this.rubro = rubro;
    }

    @Override
    public String toString() {
        return "AgregarProveedores{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", idtipocuenta=" + idtipocuenta +
                ", numerocuenta='" + numerocuenta + '\'' +
                ", moneda='" + moneda + '\'' +
                ", saldo=" + saldo +
                ", idempresa=" + idempresa +
                ", rubro='" + rubro + '\'' +
                '}';
    }
}
