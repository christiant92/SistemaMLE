/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "bien_medidacautelar", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BienMedidacautelar.findAll", query = "SELECT b FROM BienMedidacautelar b"),
    @NamedQuery(name = "BienMedidacautelar.findByIdBien", query = "SELECT b FROM BienMedidacautelar b WHERE b.bienMedidacautelarPK.idBien = :idBien"),
    @NamedQuery(name = "BienMedidacautelar.findByCodigoCautelar", query = "SELECT b FROM BienMedidacautelar b WHERE b.bienMedidacautelarPK.codigoCautelar = :codigoCautelar"),
    @NamedQuery(name = "BienMedidacautelar.findByRango", query = "SELECT b FROM BienMedidacautelar b WHERE b.rango = :rango")})
public class BienMedidacautelar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BienMedidacautelarPK bienMedidacautelarPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Rango")
    private int rango;
    @JoinColumn(name = "idBien", referencedColumnName = "idBien", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bien bien;
    @JoinColumn(name = "Codigo Cautelar", referencedColumnName = "Codigo Cautelar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medidacautelar medidacautelar;

    public BienMedidacautelar() {
    }

    public BienMedidacautelar(BienMedidacautelarPK bienMedidacautelarPK) {
        this.bienMedidacautelarPK = bienMedidacautelarPK;
    }

    public BienMedidacautelar(BienMedidacautelarPK bienMedidacautelarPK, int rango) {
        this.bienMedidacautelarPK = bienMedidacautelarPK;
        this.rango = rango;
    }

    public BienMedidacautelar(int idBien, String codigoCautelar) {
        this.bienMedidacautelarPK = new BienMedidacautelarPK(idBien, codigoCautelar);
    }

    public BienMedidacautelarPK getBienMedidacautelarPK() {
        return bienMedidacautelarPK;
    }

    public void setBienMedidacautelarPK(BienMedidacautelarPK bienMedidacautelarPK) {
        this.bienMedidacautelarPK = bienMedidacautelarPK;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Medidacautelar getMedidacautelar() {
        return medidacautelar;
    }

    public void setMedidacautelar(Medidacautelar medidacautelar) {
        this.medidacautelar = medidacautelar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bienMedidacautelarPK != null ? bienMedidacautelarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BienMedidacautelar)) {
            return false;
        }
        BienMedidacautelar other = (BienMedidacautelar) object;
        if ((this.bienMedidacautelarPK == null && other.bienMedidacautelarPK != null) || (this.bienMedidacautelarPK != null && !this.bienMedidacautelarPK.equals(other.bienMedidacautelarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.BienMedidacautelar[ bienMedidacautelarPK=" + bienMedidacautelarPK + " ]";
    }
    
}
