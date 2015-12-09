/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Christian
 */
@Embeddable
public class CuotaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "NumCuota")
    private int numCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idServ_Prestamo")
    private int idServPrestamo;

    public CuotaPK() {
    }

    public CuotaPK(int numCuota, int idServPrestamo) {
        this.numCuota = numCuota;
        this.idServPrestamo = idServPrestamo;
    }

    public int getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(int numCuota) {
        this.numCuota = numCuota;
    }

    public int getIdServPrestamo() {
        return idServPrestamo;
    }

    public void setIdServPrestamo(int idServPrestamo) {
        this.idServPrestamo = idServPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numCuota;
        hash += (int) idServPrestamo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaPK)) {
            return false;
        }
        CuotaPK other = (CuotaPK) object;
        if (this.numCuota != other.numCuota) {
            return false;
        }
        if (this.idServPrestamo != other.idServPrestamo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.CuotaPK[ numCuota=" + numCuota + ", idServPrestamo=" + idServPrestamo + " ]";
    }
    
}
