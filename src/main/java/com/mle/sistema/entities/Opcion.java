/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "opcion", catalog = "sistemamle_controldeusuarios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o"),
    @NamedQuery(name = "Opcion.findByIdOpcion", query = "SELECT o FROM Opcion o WHERE o.idOpcion = :idOpcion"),
    @NamedQuery(name = "Opcion.findByNombreOpcion", query = "SELECT o FROM Opcion o WHERE o.nombreOpcion = :nombreOpcion"),
    @NamedQuery(name = "Opcion.findByDescripcionOpcion", query = "SELECT o FROM Opcion o WHERE o.descripcionOpcion = :descripcionOpcion")})
public class Opcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOpcion")
    private Integer idOpcion;
    @Size(max = 45)
    @Column(name = "NombreOpcion")
    private String nombreOpcion;
    @Size(max = 45)
    @Column(name = "DescripcionOpcion")
    private String descripcionOpcion;
    @JoinColumn(name = "Sistema_idSistema", referencedColumnName = "idSistema")
    @ManyToOne(optional = false)
    private Sistema sistemaidSistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcion")
    private List<Subopcion> subopcionList;

    public Opcion() {
    }

    public Opcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }

    public String getDescripcionOpcion() {
        return descripcionOpcion;
    }

    public void setDescripcionOpcion(String descripcionOpcion) {
        this.descripcionOpcion = descripcionOpcion;
    }

    public Sistema getSistemaidSistema() {
        return sistemaidSistema;
    }

    public void setSistemaidSistema(Sistema sistemaidSistema) {
        this.sistemaidSistema = sistemaidSistema;
    }

    @XmlTransient
    public List<Subopcion> getSubopcionList() {
        return subopcionList;
    }

    public void setSubopcionList(List<Subopcion> subopcionList) {
        this.subopcionList = subopcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Opcion[ idOpcion=" + idOpcion + " ]";
    }
    
}
