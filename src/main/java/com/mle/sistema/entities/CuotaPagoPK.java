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
public class CuotaPagoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idServ_Prestamo")
    private int idServPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuota_NumCuota")
    private int cuotaNumCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pago_idPago")
    private int pagoidPago;

    public CuotaPagoPK() {
    }

    public CuotaPagoPK(int idServPrestamo, int cuotaNumCuota, int pagoidPago) {
        this.idServPrestamo = idServPrestamo;
        this.cuotaNumCuota = cuotaNumCuota;
        this.pagoidPago = pagoidPago;
    }

    public int getIdServPrestamo() {
        return idServPrestamo;
    }

    public void setIdServPrestamo(int idServPrestamo) {
        this.idServPrestamo = idServPrestamo;
    }

    public int getCuotaNumCuota() {
        return cuotaNumCuota;
    }

    public void setCuotaNumCuota(int cuotaNumCuota) {
        this.cuotaNumCuota = cuotaNumCuota;
    }

    public int getPagoidPago() {
        return pagoidPago;
    }

    public void setPagoidPago(int pagoidPago) {
        this.pagoidPago = pagoidPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idServPrestamo;
        hash += (int) cuotaNumCuota;
        hash += (int) pagoidPago;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaPagoPK)) {
            return false;
        }
        CuotaPagoPK other = (CuotaPagoPK) object;
        if (this.idServPrestamo != other.idServPrestamo) {
            return false;
        }
        if (this.cuotaNumCuota != other.cuotaNumCuota) {
            return false;
        }
        if (this.pagoidPago != other.pagoidPago) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.CuotaPagoPK[ idServPrestamo=" + idServPrestamo + ", cuotaNumCuota=" + cuotaNumCuota + ", pagoidPago=" + pagoidPago + " ]";
    }
    
}
