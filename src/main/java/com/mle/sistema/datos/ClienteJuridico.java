/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.datos;

/**
 *
 * @author christian
 */
public class ClienteJuridico extends Cliente {
    private int ruc;
    private String razonSocial;

    public ClienteJuridico() {
    }

    public ClienteJuridico(int ruc, String razonSocial, String direccion, String distrito, String provincia, int telefono, String email) {
        super(direccion, distrito, provincia, telefono, email);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
