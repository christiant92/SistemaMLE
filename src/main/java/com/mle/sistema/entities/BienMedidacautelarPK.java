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
public class BienMedidacautelarPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBien")
    private int idBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Codigo Cautelar")
    private String codigoCautelar;

    public BienMedidacautelarPK() {
    }

    public BienMedidacautelarPK(int idBien, String codigoCautelar) {
        this.idBien = idBien;
        this.codigoCautelar = codigoCautelar;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public String getCodigoCautelar() {
        return codigoCautelar;
    }

    public void setCodigoCautelar(String codigoCautelar) {
        this.codigoCautelar = codigoCautelar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBien;
        hash += (codigoCautelar != null ? codigoCautelar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BienMedidacautelarPK)) {
            return false;
        }
        BienMedidacautelarPK other = (BienMedidacautelarPK) object;
        if (this.idBien != other.idBien) {
            return false;
        }
        if ((this.codigoCautelar == null && other.codigoCautelar != null) || (this.codigoCautelar != null && !this.codigoCautelar.equals(other.codigoCautelar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.BienMedidacautelarPK[ idBien=" + idBien + ", codigoCautelar=" + codigoCautelar + " ]";
    }
    
}
