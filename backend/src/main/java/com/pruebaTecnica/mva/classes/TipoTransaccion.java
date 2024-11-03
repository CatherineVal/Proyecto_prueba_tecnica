package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_transaccion")
public class TipoTransaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idtipotransaccion;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String descripcion;

    public TipoTransaccion(){

    }

    public Long getIdtransaccion() {
        return idtipotransaccion;
    }

    public void setIdtransaccion(Long idtransaccion) {
        this.idtipotransaccion = idtransaccion;
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

    public TipoTransaccion(Long idtransaccion, String nombre, String descripcion) {
        this.idtipotransaccion = idtransaccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
