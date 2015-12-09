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
 * @author Christian
 */
@Embeddable
public class ProgramacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProgramacion")
    private int idProgramacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nro_Expediente")
    private String nroExpediente;

    public ProgramacionPK() {
    }

    public ProgramacionPK(int idProgramacion, String nroExpediente) {
        this.idProgramacion = idProgramacion;
        this.nroExpediente = nroExpediente;
    }

    public int getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(int idProgramacion) {
        this.idProgramacion = idProgramacion;
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
        hash += (int) idProgramacion;
        hash += (nroExpediente != null ? nroExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionPK)) {
            return false;
        }
        ProgramacionPK other = (ProgramacionPK) object;
        if (this.idProgramacion != other.idProgramacion) {
            return false;
        }
        if ((this.nroExpediente == null && other.nroExpediente != null) || (this.nroExpediente != null && !this.nroExpediente.equals(other.nroExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.ProgramacionPK[ idProgramacion=" + idProgramacion + ", nroExpediente=" + nroExpediente + " ]";
    }
    
}
