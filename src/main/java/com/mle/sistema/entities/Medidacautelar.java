/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "medidacautelar", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medidacautelar.findAll", query = "SELECT m FROM Medidacautelar m"),
    @NamedQuery(name = "Medidacautelar.findByCodigoCautelar", query = "SELECT m FROM Medidacautelar m WHERE m.codigoCautelar = :codigoCautelar"),
    @NamedQuery(name = "Medidacautelar.findByFPresentacionMC", query = "SELECT m FROM Medidacautelar m WHERE m.fPresentacionMC = :fPresentacionMC"),
    @NamedQuery(name = "Medidacautelar.findByFInscripcionMC", query = "SELECT m FROM Medidacautelar m WHERE m.fInscripcionMC = :fInscripcionMC"),
    @NamedQuery(name = "Medidacautelar.findByFFormalizacionMC", query = "SELECT m FROM Medidacautelar m WHERE m.fFormalizacionMC = :fFormalizacionMC")})
public class Medidacautelar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Codigo Cautelar")
    private String codigoCautelar;
    @Column(name = "F_Presentacion_MC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fPresentacionMC;
    @Column(name = "F_Inscripcion_MC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fInscripcionMC;
    @Column(name = "F_Formalizacion_MC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFormalizacionMC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medidacautelar")
    private List<BienMedidacautelar> bienMedidacautelarList;
    @OneToMany(mappedBy = "codigoCautelar")
    private List<Procesojudicial> procesojudicialList;

    public Medidacautelar() {
    }

    public Medidacautelar(String codigoCautelar) {
        this.codigoCautelar = codigoCautelar;
    }

    public String getCodigoCautelar() {
        return codigoCautelar;
    }

    public void setCodigoCautelar(String codigoCautelar) {
        this.codigoCautelar = codigoCautelar;
    }

    public Date getFPresentacionMC() {
        return fPresentacionMC;
    }

    public void setFPresentacionMC(Date fPresentacionMC) {
        this.fPresentacionMC = fPresentacionMC;
    }

    public Date getFInscripcionMC() {
        return fInscripcionMC;
    }

    public void setFInscripcionMC(Date fInscripcionMC) {
        this.fInscripcionMC = fInscripcionMC;
    }

    public Date getFFormalizacionMC() {
        return fFormalizacionMC;
    }

    public void setFFormalizacionMC(Date fFormalizacionMC) {
        this.fFormalizacionMC = fFormalizacionMC;
    }

    @XmlTransient
    public List<BienMedidacautelar> getBienMedidacautelarList() {
        return bienMedidacautelarList;
    }

    public void setBienMedidacautelarList(List<BienMedidacautelar> bienMedidacautelarList) {
        this.bienMedidacautelarList = bienMedidacautelarList;
    }

    @XmlTransient
    public List<Procesojudicial> getProcesojudicialList() {
        return procesojudicialList;
    }

    public void setProcesojudicialList(List<Procesojudicial> procesojudicialList) {
        this.procesojudicialList = procesojudicialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCautelar != null ? codigoCautelar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medidacautelar)) {
            return false;
        }
        Medidacautelar other = (Medidacautelar) object;
        if ((this.codigoCautelar == null && other.codigoCautelar != null) || (this.codigoCautelar != null && !this.codigoCautelar.equals(other.codigoCautelar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Medidacautelar[ codigoCautelar=" + codigoCautelar + " ]";
    }
    
}
