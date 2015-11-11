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
public class ImagenPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idImagen")
    private int idImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Documento_idDocumento")
    private int documentoidDocumento;

    public ImagenPK() {
    }

    public ImagenPK(int idImagen, int documentoidDocumento) {
        this.idImagen = idImagen;
        this.documentoidDocumento = documentoidDocumento;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getDocumentoidDocumento() {
        return documentoidDocumento;
    }

    public void setDocumentoidDocumento(int documentoidDocumento) {
        this.documentoidDocumento = documentoidDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idImagen;
        hash += (int) documentoidDocumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenPK)) {
            return false;
        }
        ImagenPK other = (ImagenPK) object;
        if (this.idImagen != other.idImagen) {
            return false;
        }
        if (this.documentoidDocumento != other.documentoidDocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.ImagenPK[ idImagen=" + idImagen + ", documentoidDocumento=" + documentoidDocumento + " ]";
    }
    
}
