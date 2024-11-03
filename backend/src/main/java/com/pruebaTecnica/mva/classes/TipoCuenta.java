package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "tipo_cuenta")
public class TipoCuenta {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idtipocuenta;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String descripcion;


    @Column(unique = true, nullable = false)
    private String codigo;






    public TipoCuenta(){

    }

    public Long getIdtipocuenta() {
        return idtipocuenta;
    }

    public void setIdtipocuenta(Long idtipocuenta) {
        this.idtipocuenta = idtipocuenta;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoCuenta(Long idtipocuenta, String nombre, String descripcion, String codigo) {
        this.idtipocuenta = idtipocuenta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;

    }
}
