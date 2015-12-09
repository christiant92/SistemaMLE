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
public class JuzgadoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJuzgado")
    private int idJuzgado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLugarJuzgado")
    private int idLugarJuzgado;

    public JuzgadoPK() {
    }

    public JuzgadoPK(int idJuzgado, int idLugarJuzgado) {
        this.idJuzgado = idJuzgado;
        this.idLugarJuzgado = idLugarJuzgado;
    }

    public int getIdJuzgado() {
        return idJuzgado;
    }

    public void setIdJuzgado(int idJuzgado) {
        this.idJuzgado = idJuzgado;
    }

    public int getIdLugarJuzgado() {
        return idLugarJuzgado;
    }

    public void setIdLugarJuzgado(int idLugarJuzgado) {
        this.idLugarJuzgado = idLugarJuzgado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idJuzgado;
        hash += (int) idLugarJuzgado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuzgadoPK)) {
            return false;
        }
        JuzgadoPK other = (JuzgadoPK) object;
        if (this.idJuzgado != other.idJuzgado) {
            return false;
        }
        if (this.idLugarJuzgado != other.idLugarJuzgado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.JuzgadoPK[ idJuzgado=" + idJuzgado + ", idLugarJuzgado=" + idLugarJuzgado + " ]";
    }
    
}
