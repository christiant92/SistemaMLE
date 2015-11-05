/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "subopcion", catalog = "sistemamle_controldeusuarios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subopcion.findAll", query = "SELECT s FROM Subopcion s"),
    @NamedQuery(name = "Subopcion.findByIdSubOpcion", query = "SELECT s FROM Subopcion s WHERE s.subopcionPK.idSubOpcion = :idSubOpcion"),
    @NamedQuery(name = "Subopcion.findByOpcionidOpcion", query = "SELECT s FROM Subopcion s WHERE s.subopcionPK.opcionidOpcion = :opcionidOpcion"),
    @NamedQuery(name = "Subopcion.findByNombreSubOpcion", query = "SELECT s FROM Subopcion s WHERE s.nombreSubOpcion = :nombreSubOpcion"),
    @NamedQuery(name = "Subopcion.findByDescripcionSubOpcion", query = "SELECT s FROM Subopcion s WHERE s.descripcionSubOpcion = :descripcionSubOpcion")})
public class Subopcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubopcionPK subopcionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NombreSubOpcion")
    private String nombreSubOpcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DescripcionSubOpcion")
    private String descripcionSubOpcion;
    @ManyToMany(mappedBy = "subopcionList")
    private List<Rol> rolList;
    @JoinColumn(name = "Opcion_idOpcion", referencedColumnName = "idOpcion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Opcion opcion;

    public Subopcion() {
    }

    public Subopcion(SubopcionPK subopcionPK) {
        this.subopcionPK = subopcionPK;
    }

    public Subopcion(SubopcionPK subopcionPK, String nombreSubOpcion, String descripcionSubOpcion) {
        this.subopcionPK = subopcionPK;
        this.nombreSubOpcion = nombreSubOpcion;
        this.descripcionSubOpcion = descripcionSubOpcion;
    }

    public Subopcion(int idSubOpcion, int opcionidOpcion) {
        this.subopcionPK = new SubopcionPK(idSubOpcion, opcionidOpcion);
    }

    public SubopcionPK getSubopcionPK() {
        return subopcionPK;
    }

    public void setSubopcionPK(SubopcionPK subopcionPK) {
        this.subopcionPK = subopcionPK;
    }

    public String getNombreSubOpcion() {
        return nombreSubOpcion;
    }

    public void setNombreSubOpcion(String nombreSubOpcion) {
        this.nombreSubOpcion = nombreSubOpcion;
    }

    public String getDescripcionSubOpcion() {
        return descripcionSubOpcion;
    }

    public void setDescripcionSubOpcion(String descripcionSubOpcion) {
        this.descripcionSubOpcion = descripcionSubOpcion;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subopcionPK != null ? subopcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subopcion)) {
            return false;
        }
        Subopcion other = (Subopcion) object;
        if ((this.subopcionPK == null && other.subopcionPK != null) || (this.subopcionPK != null && !this.subopcionPK.equals(other.subopcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Subopcion[ subopcionPK=" + subopcionPK + " ]";
    }
    
}
