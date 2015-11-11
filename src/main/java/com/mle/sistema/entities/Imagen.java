/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "imagen", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i"),
    @NamedQuery(name = "Imagen.findByIdImagen", query = "SELECT i FROM Imagen i WHERE i.imagenPK.idImagen = :idImagen"),
    @NamedQuery(name = "Imagen.findByDocumentoidDocumento", query = "SELECT i FROM Imagen i WHERE i.imagenPK.documentoidDocumento = :documentoidDocumento")})
public class Imagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImagenPK imagenPK;
    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;
    @JoinColumn(name = "Documento_idDocumento", referencedColumnName = "idDocumento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Documento documento;

    public Imagen() {
    }

    public Imagen(ImagenPK imagenPK) {
        this.imagenPK = imagenPK;
    }

    public Imagen(int idImagen, int documentoidDocumento) {
        this.imagenPK = new ImagenPK(idImagen, documentoidDocumento);
    }

    public ImagenPK getImagenPK() {
        return imagenPK;
    }

    public void setImagenPK(ImagenPK imagenPK) {
        this.imagenPK = imagenPK;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagenPK != null ? imagenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.imagenPK == null && other.imagenPK != null) || (this.imagenPK != null && !this.imagenPK.equals(other.imagenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Imagen[ imagenPK=" + imagenPK + " ]";
    }
    
}
