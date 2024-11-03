package com.pruebaTecnica.mva.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "cuenta")

public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idcuenta;

    @Column(unique = true, nullable = false)
    private String numerocuenta;

    @Column(unique = true, nullable = false)
    private String moneda;

    @Column(unique = true, nullable = false)
    private Float saldo;

    @Column(unique = true, nullable = false)
    private Boolean activa;

    @ManyToOne
    @JoinColumn(name = "idtipocuenta")
    private TipoCuenta tipocuenta;

    @Override
    public String toString() {
        return "Cuenta{" +
                "idcuenta=" + idcuenta +
                ", numerocuenta='" + numerocuenta + '\'' +
                ", moneda='" + moneda + '\'' +
                ", saldo=" + saldo +
                ", activa=" + activa +
                ", tipocuenta=" + tipocuenta +
                '}';
    }

    public Cuenta(){

    }


    public Long getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Long idcuenta) {
        this.idcuenta = idcuenta;
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

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public TipoCuenta getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(TipoCuenta tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public Cuenta(Long idcuenta, String numerocuenta, String moneda, Float saldo, Boolean activa, TipoCuenta tipocuenta) {
        this.idcuenta = idcuenta;
        this.numerocuenta = numerocuenta;
        this.moneda = moneda;
        this.saldo = saldo;
        this.activa = activa;
        this.tipocuenta = tipocuenta;
    }
}
