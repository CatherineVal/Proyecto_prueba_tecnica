package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

@Entity
@Table(name="empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long idempresa;


    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = false, nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idcuenta")
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Column(unique = false, nullable = false)
    private String rtn;


    public Empresa(){

    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
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

    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn;
    }

    public Empresa(Long idempresa, String nombre, String descripcion, Cuenta cuenta, Usuario usuario, String rtn) {
        this.idempresa = idempresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cuenta = cuenta;
        this.usuario = usuario;
        this.rtn = rtn;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idempresa=" + idempresa +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cuenta=" + cuenta +
                ", usuario=" + usuario +
                '}';
    }
}
