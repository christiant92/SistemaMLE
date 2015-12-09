/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.datos;

import java.io.Serializable;

/**
 *
 * @author christian
 */
public class Bien implements Serializable {
    private int id;
    private int nroPartida;
    private String tipoBien;
    private String ubicacion;
    private float montoValorizado;
    private String tipoPropietario;
    private String descripcion;
    //private byte[] imagen;

    public Bien() {
    }

    public Bien(int nroPartida, String tipoBien, String ubicacion, float montoValorizado, String tipoPropietario, String descripcion) {
        this.nroPartida = nroPartida;
        this.tipoBien = tipoBien;
        this.ubicacion = ubicacion;
        this.montoValorizado = montoValorizado;
        this.tipoPropietario = tipoPropietario;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getNroPartida() {
        return nroPartida;
    }

    public void setNroPartida(int nroPartida) {
        this.nroPartida = nroPartida;
    }

    public String getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(String tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getMontoValorizado() {
        return montoValorizado;
    }

    public void setMontoValorizado(float montoValorizado) {
        this.montoValorizado = montoValorizado;
    }

    public String getTipoPropietario() {
        return tipoPropietario;
    }

    public void setTipoPropietario(String tipoPropietario) {
        this.tipoPropietario = tipoPropietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
