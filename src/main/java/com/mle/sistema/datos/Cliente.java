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
public class Cliente {
    private String direccion;
    private String distrito;
    private String provincia;
    private int telefono;
    private String email;

    public Cliente(String direccion, String distrito, String provincia, int telefono, String email) {
        this.direccion = direccion;
        this.distrito = distrito;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
    }

    public Cliente() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
