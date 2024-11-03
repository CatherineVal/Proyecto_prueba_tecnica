package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

@Entity
@Table(name ="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long idempleado;

    public Empleado(){

    }

    @Column(unique = true, nullable = false)
    private String nombres;

    @Column(unique = true, nullable = false)
    private String apellidos;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(unique = true, nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "idcuenta")
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public Long getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Long idempleado) {
        this.idempleado = idempleado;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empleado(Long idempleado, String nombres, String apellidos, String correo, String codigo, Cuenta cuenta, Empresa empresa) {
        this.idempleado = idempleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.codigo = codigo;
        this.cuenta = cuenta;
        this.empresa = empresa;
    }
}
