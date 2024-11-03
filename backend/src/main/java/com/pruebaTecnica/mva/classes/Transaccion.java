package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long idtransaccion;


    @Column(unique = true, nullable = false)
    private Float monto;

    @Column(unique = false, nullable = false)
    private Date fecha;

    @Column(unique = false, nullable = false)
    private String numerocuenta;

    @ManyToOne
    @JoinColumn(name = "idtipotransaccion")
    private TipoTransaccion tipotransaccion;

    @ManyToOne
    @JoinColumn(name = "idbancoorigen")
    private Banco idbancoorigen;

    @ManyToOne
    @JoinColumn(name = "idbancodestino")
    private Banco idbancodestino;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public Transaccion(){

    }

    public Long getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(Long idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public TipoTransaccion getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(TipoTransaccion tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public Banco getIdbancoorigen() {
        return idbancoorigen;
    }

    public void setIdbancoorigen(Banco idbancoorigen) {
        this.idbancoorigen = idbancoorigen;
    }

    public Banco getIdbancodestino() {
        return idbancodestino;
    }

    public void setIdbancodestino(Banco idbancodestino) {
        this.idbancodestino = idbancodestino;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Transaccion(Long idtransaccion, Float monto, Date fecha, String numerocuenta, TipoTransaccion tipotransaccion, Banco idbancoorigen, Banco idbancodestino, Empresa empresa) {
        this.idtransaccion = idtransaccion;
        this.monto = monto;
        this.fecha = fecha;
        this.numerocuenta = numerocuenta;
        this.tipotransaccion = tipotransaccion;
        this.idbancoorigen = idbancoorigen;
        this.idbancodestino = idbancodestino;
        this.empresa = empresa;
    }
}
