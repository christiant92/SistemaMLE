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
import javax.persistence.JoinColumns;
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
@Table(name = "cuota_pago", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuotaPago.findAll", query = "SELECT c FROM CuotaPago c"),
    @NamedQuery(name = "CuotaPago.findByIdServPrestamo", query = "SELECT c FROM CuotaPago c WHERE c.cuotaPagoPK.idServPrestamo = :idServPrestamo"),
    @NamedQuery(name = "CuotaPago.findByCuotaNumCuota", query = "SELECT c FROM CuotaPago c WHERE c.cuotaPagoPK.cuotaNumCuota = :cuotaNumCuota"),
    @NamedQuery(name = "CuotaPago.findByPagoidPago", query = "SELECT c FROM CuotaPago c WHERE c.cuotaPagoPK.pagoidPago = :pagoidPago"),
    @NamedQuery(name = "CuotaPago.findByMonto", query = "SELECT c FROM CuotaPago c WHERE c.monto = :monto")})
public class CuotaPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuotaPagoPK cuotaPagoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private float monto;
    @JoinColumns({
        @JoinColumn(name = "Cuota_NumCuota", referencedColumnName = "NumCuota", insertable = false, updatable = false),
        @JoinColumn(name = "idServ_Prestamo", referencedColumnName = "idServ_Prestamo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cuota cuota;
    @JoinColumn(name = "Pago_idPago", referencedColumnName = "idPago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pago pago;

    public CuotaPago() {
    }

    public CuotaPago(CuotaPagoPK cuotaPagoPK) {
        this.cuotaPagoPK = cuotaPagoPK;
    }

    public CuotaPago(CuotaPagoPK cuotaPagoPK, float monto) {
        this.cuotaPagoPK = cuotaPagoPK;
        this.monto = monto;
    }

    public CuotaPago(int idServPrestamo, int cuotaNumCuota, int pagoidPago) {
        this.cuotaPagoPK = new CuotaPagoPK(idServPrestamo, cuotaNumCuota, pagoidPago);
    }

    public CuotaPagoPK getCuotaPagoPK() {
        return cuotaPagoPK;
    }

    public void setCuotaPagoPK(CuotaPagoPK cuotaPagoPK) {
        this.cuotaPagoPK = cuotaPagoPK;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuotaPagoPK != null ? cuotaPagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaPago)) {
            return false;
        }
        CuotaPago other = (CuotaPago) object;
        if ((this.cuotaPagoPK == null && other.cuotaPagoPK != null) || (this.cuotaPagoPK != null && !this.cuotaPagoPK.equals(other.cuotaPagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.CuotaPago[ cuotaPagoPK=" + cuotaPagoPK + " ]";
    }
    
}
