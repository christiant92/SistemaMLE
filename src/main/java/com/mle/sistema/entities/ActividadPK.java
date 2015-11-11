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
import javax.validation.constraints.Size;

/**
 *
 * @author christian
 */
@Embeddable
public class ActividadPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idActividad")
    private int idActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nro_Expediente")
    private String nroExpediente;

    public ActividadPK() {
    }

    public ActividadPK(int idActividad, String nroExpediente) {
        this.idActividad = idActividad;
        this.nroExpediente = nroExpediente;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNroExpediente() {
        return nroExpediente;
    }

    public void setNroExpediente(String nroExpediente) {
        this.nroExpediente = nroExpediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActividad;
        hash += (nroExpediente != null ? nroExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadPK)) {
            return false;
        }
        ActividadPK other = (ActividadPK) object;
        if (this.idActividad != other.idActividad) {
            return false;
        }
        if ((this.nroExpediente == null && other.nroExpediente != null) || (this.nroExpediente != null && !this.nroExpediente.equals(other.nroExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.ActividadPK[ idActividad=" + idActividad + ", nroExpediente=" + nroExpediente + " ]";
    }
    
}
