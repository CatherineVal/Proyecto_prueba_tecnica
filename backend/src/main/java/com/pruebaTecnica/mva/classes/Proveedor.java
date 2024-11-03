package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = true)
    private Long idproveedor;

    @Column(unique = true,nullable = false)
    private String nombre;

    @Column(unique = true,nullable = false)
    private String departamento;

    @ManyToOne
    @JoinColumn(name = "idcuenta")
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    @Column(unique = true,nullable = false)
    private String rubro;

    public Proveedor(){

    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Long getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Long idproveedor) {
        this.idproveedor = idproveedor;
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


    public Proveedor(Long idproveedor, String nombre, String departamento, Cuenta cuenta, Empresa empresa, String rubro) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.departamento = departamento;
        this.cuenta = cuenta;
        this.empresa = empresa;
        this.rubro = rubro;
    }
}
