package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

@Entity
@Table( name = "banco")


public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long idbanco;


    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = false, nullable = false)
    private String descripcion;


    public Banco(){

    }

    public Long getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Long idbanco) {
        this.idbanco = idbanco;
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

    public Banco(Long idbanco, String nombre, String descripcion) {
        this.idbanco = idbanco;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }




}
