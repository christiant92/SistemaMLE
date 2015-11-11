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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "lugarjuzgado", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugarjuzgado.findAll", query = "SELECT l FROM Lugarjuzgado l"),
    @NamedQuery(name = "Lugarjuzgado.findByIdLugarJuzgado", query = "SELECT l FROM Lugarjuzgado l WHERE l.idLugarJuzgado = :idLugarJuzgado"),
    @NamedQuery(name = "Lugarjuzgado.findByDistrito", query = "SELECT l FROM Lugarjuzgado l WHERE l.distrito = :distrito")})
public class Lugarjuzgado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLugarJuzgado")
    private Integer idLugarJuzgado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Distrito")
    private String distrito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugarjuzgado")
    private List<Juzgado> juzgadoList;

    public Lugarjuzgado() {
    }

    public Lugarjuzgado(Integer idLugarJuzgado) {
        this.idLugarJuzgado = idLugarJuzgado;
    }

    public Lugarjuzgado(Integer idLugarJuzgado, String distrito) {
        this.idLugarJuzgado = idLugarJuzgado;
        this.distrito = distrito;
    }

    public Integer getIdLugarJuzgado() {
        return idLugarJuzgado;
    }

    public void setIdLugarJuzgado(Integer idLugarJuzgado) {
        this.idLugarJuzgado = idLugarJuzgado;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @XmlTransient
    public List<Juzgado> getJuzgadoList() {
        return juzgadoList;
    }

    public void setJuzgadoList(List<Juzgado> juzgadoList) {
        this.juzgadoList = juzgadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugarJuzgado != null ? idLugarJuzgado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugarjuzgado)) {
            return false;
        }
        Lugarjuzgado other = (Lugarjuzgado) object;
        if ((this.idLugarJuzgado == null && other.idLugarJuzgado != null) || (this.idLugarJuzgado != null && !this.idLugarJuzgado.equals(other.idLugarJuzgado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Lugarjuzgado[ idLugarJuzgado=" + idLugarJuzgado + " ]";
    }
    
}
