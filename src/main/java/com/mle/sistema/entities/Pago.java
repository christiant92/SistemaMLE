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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author christian
 */
@Entity
@Table(name = "pago", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "Pago.findByNumOperacionCheque", query = "SELECT p FROM Pago p WHERE p.numOperacionCheque = :numOperacionCheque"),
    @NamedQuery(name = "Pago.findByMontoPago", query = "SELECT p FROM Pago p WHERE p.montoPago = :montoPago"),
    @NamedQuery(name = "Pago.findByFechaPago", query = "SELECT p FROM Pago p WHERE p.fechaPago = :fechaPago")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPago")
    private Integer idPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Num_Operacion_Cheque")
    private String numOperacionCheque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto_Pago")
    private float montoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @JoinColumn(name = "idDocumento_Voucher_Cheque", referencedColumnName = "idDocumento")
    @ManyToOne(optional = false)
    private Documento idDocumentoVoucherCheque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pago")
    private List<CuotaPago> cuotaPagoList;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Pago(Integer idPago, String numOperacionCheque, float montoPago, Date fechaPago) {
        this.idPago = idPago;
        this.numOperacionCheque = numOperacionCheque;
        this.montoPago = montoPago;
        this.fechaPago = fechaPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getNumOperacionCheque() {
        return numOperacionCheque;
    }

    public void setNumOperacionCheque(String numOperacionCheque) {
        this.numOperacionCheque = numOperacionCheque;
    }

    public float getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(float montoPago) {
        this.montoPago = montoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Documento getIdDocumentoVoucherCheque() {
        return idDocumentoVoucherCheque;
    }

    public void setIdDocumentoVoucherCheque(Documento idDocumentoVoucherCheque) {
        this.idDocumentoVoucherCheque = idDocumentoVoucherCheque;
    }

    @XmlTransient
    public List<CuotaPago> getCuotaPagoList() {
        return cuotaPagoList;
    }

    public void setCuotaPagoList(List<CuotaPago> cuotaPagoList) {
        this.cuotaPagoList = cuotaPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Pago[ idPago=" + idPago + " ]";
    }
    
}
