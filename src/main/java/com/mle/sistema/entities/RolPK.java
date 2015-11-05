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
 * @author christian
 */
@Embeddable
public class RolPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idRol")
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sistema_idSistema")
    private int sistemaidSistema;

    public RolPK() {
    }

    public RolPK(int idRol, int sistemaidSistema) {
        this.idRol = idRol;
        this.sistemaidSistema = sistemaidSistema;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getSistemaidSistema() {
        return sistemaidSistema;
    }

    public void setSistemaidSistema(int sistemaidSistema) {
        this.sistemaidSistema = sistemaidSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRol;
        hash += (int) sistemaidSistema;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPK)) {
            return false;
        }
        RolPK other = (RolPK) object;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.sistemaidSistema != other.sistemaidSistema) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.RolPK[ idRol=" + idRol + ", sistemaidSistema=" + sistemaidSistema + " ]";
    }
    
}
