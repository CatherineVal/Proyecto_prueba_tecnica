package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long idcliente;


    @Column(unique = true, nullable = false)
    private String numerocuenta;

    @Column(unique = false, nullable = false)
    private String nombres;

    @Column(unique = false, nullable = false)
    private String apellidos;

    @Column(unique = false, nullable = false)
    private String correo;

    @Column(unique = false, nullable = false)
    private String dni;

    @ManyToOne
    @JoinColumn(name = "idcuenta")
    private Cuenta cuenta;


    public Cliente(){

    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente(Long idcliente, String numerocuenta, String nombres, String apellidos, String correo, String dni, Cuenta cuenta) {
        this.idcliente = idcliente;
        this.numerocuenta = numerocuenta;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.dni = dni;
        this.cuenta = cuenta;
    }
}
