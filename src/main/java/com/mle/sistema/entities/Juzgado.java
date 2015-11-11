/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "juzgado", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juzgado.findAll", query = "SELECT j FROM Juzgado j"),
    @NamedQuery(name = "Juzgado.findByIdJuzgado", query = "SELECT j FROM Juzgado j WHERE j.juzgadoPK.idJuzgado = :idJuzgado"),
    @NamedQuery(name = "Juzgado.findByIdLugarJuzgado", query = "SELECT j FROM Juzgado j WHERE j.juzgadoPK.idLugarJuzgado = :idLugarJuzgado")})
public class Juzgado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JuzgadoPK juzgadoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juzgado")
    private List<Procesojudicial> procesojudicialList;
    @JoinColumn(name = "idLugarJuzgado", referencedColumnName = "idLugarJuzgado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lugarjuzgado lugarjuzgado;

    public Juzgado() {
    }

    public Juzgado(JuzgadoPK juzgadoPK) {
        this.juzgadoPK = juzgadoPK;
    }

    public Juzgado(int idJuzgado, int idLugarJuzgado) {
        this.juzgadoPK = new JuzgadoPK(idJuzgado, idLugarJuzgado);
    }

    public JuzgadoPK getJuzgadoPK() {
        return juzgadoPK;
    }

    public void setJuzgadoPK(JuzgadoPK juzgadoPK) {
        this.juzgadoPK = juzgadoPK;
    }

    @XmlTransient
    public List<Procesojudicial> getProcesojudicialList() {
        return procesojudicialList;
    }

    public void setProcesojudicialList(List<Procesojudicial> procesojudicialList) {
        this.procesojudicialList = procesojudicialList;
    }

    public Lugarjuzgado getLugarjuzgado() {
        return lugarjuzgado;
    }

    public void setLugarjuzgado(Lugarjuzgado lugarjuzgado) {
        this.lugarjuzgado = lugarjuzgado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (juzgadoPK != null ? juzgadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juzgado)) {
            return false;
        }
        Juzgado other = (Juzgado) object;
        if ((this.juzgadoPK == null && other.juzgadoPK != null) || (this.juzgadoPK != null && !this.juzgadoPK.equals(other.juzgadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Juzgado[ juzgadoPK=" + juzgadoPK + " ]";
    }
    
}
