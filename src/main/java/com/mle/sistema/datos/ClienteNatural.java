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
public class ClienteNatural extends Cliente {
    private int dni;
    private String nombres;
    private String apellidos;
    private int celular;
    private String cuentaDeposito;

    public ClienteNatural() {
    }

    public ClienteNatural(int dni, String nombres, String apellidos, int celular, String cuentaDeposito, String direccion, String distrito, String provincia, int telefono, String email) {
        super(direccion, distrito, provincia, telefono, email);
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.cuentaDeposito = cuentaDeposito;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCuentaDeposito() {
        return cuentaDeposito;
    }

    public void setCuentaDeposito(String cuentaDeposito) {
        this.cuentaDeposito = cuentaDeposito;
    }
}
