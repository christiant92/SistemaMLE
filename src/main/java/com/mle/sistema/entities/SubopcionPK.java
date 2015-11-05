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
public class SubopcionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idSubOpcion")
    private int idSubOpcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Opcion_idOpcion")
    private int opcionidOpcion;

    public SubopcionPK() {
    }

    public SubopcionPK(int idSubOpcion, int opcionidOpcion) {
        this.idSubOpcion = idSubOpcion;
        this.opcionidOpcion = opcionidOpcion;
    }

    public int getIdSubOpcion() {
        return idSubOpcion;
    }

    public void setIdSubOpcion(int idSubOpcion) {
        this.idSubOpcion = idSubOpcion;
    }

    public int getOpcionidOpcion() {
        return opcionidOpcion;
    }

    public void setOpcionidOpcion(int opcionidOpcion) {
        this.opcionidOpcion = opcionidOpcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSubOpcion;
        hash += (int) opcionidOpcion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubopcionPK)) {
            return false;
        }
        SubopcionPK other = (SubopcionPK) object;
        if (this.idSubOpcion != other.idSubOpcion) {
            return false;
        }
        if (this.opcionidOpcion != other.opcionidOpcion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.SubopcionPK[ idSubOpcion=" + idSubOpcion + ", opcionidOpcion=" + opcionidOpcion + " ]";
    }
    
}
