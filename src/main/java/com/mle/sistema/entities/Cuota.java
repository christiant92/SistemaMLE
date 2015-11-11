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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "cuota", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c"),
    @NamedQuery(name = "Cuota.findByNumCuota", query = "SELECT c FROM Cuota c WHERE c.cuotaPK.numCuota = :numCuota"),
    @NamedQuery(name = "Cuota.findByIdServPrestamo", query = "SELECT c FROM Cuota c WHERE c.cuotaPK.idServPrestamo = :idServPrestamo"),
    @NamedQuery(name = "Cuota.findByEstado", query = "SELECT c FROM Cuota c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cuota.findByMontosaldado", query = "SELECT c FROM Cuota c WHERE c.montosaldado = :montosaldado"),
    @NamedQuery(name = "Cuota.findByFechacuota", query = "SELECT c FROM Cuota c WHERE c.fechacuota = :fechacuota")})
public class Cuota implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuotaPK cuotaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto_saldado")
    private float montosaldado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_cuota")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacuota;
    @JoinColumn(name = "idServ_Prestamo", referencedColumnName = "idServ_Prestamo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServPrestamo servPrestamo;
    @JoinColumn(name = "idDocumento_TituloValor", referencedColumnName = "idDocumento")
    @ManyToOne
    private Documento idDocumentoTituloValor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuota")
    private List<CuotaPago> cuotaPagoList;

    public Cuota() {
    }

    public Cuota(CuotaPK cuotaPK) {
        this.cuotaPK = cuotaPK;
    }

    public Cuota(CuotaPK cuotaPK, Character estado, float montosaldado, Date fechacuota) {
        this.cuotaPK = cuotaPK;
        this.estado = estado;
        this.montosaldado = montosaldado;
        this.fechacuota = fechacuota;
    }

    public Cuota(int numCuota, int idServPrestamo) {
        this.cuotaPK = new CuotaPK(numCuota, idServPrestamo);
    }

    public CuotaPK getCuotaPK() {
        return cuotaPK;
    }

    public void setCuotaPK(CuotaPK cuotaPK) {
        this.cuotaPK = cuotaPK;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public float getMontosaldado() {
        return montosaldado;
    }

    public void setMontosaldado(float montosaldado) {
        this.montosaldado = montosaldado;
    }

    public Date getFechacuota() {
        return fechacuota;
    }

    public void setFechacuota(Date fechacuota) {
        this.fechacuota = fechacuota;
    }

    public ServPrestamo getServPrestamo() {
        return servPrestamo;
    }

    public void setServPrestamo(ServPrestamo servPrestamo) {
        this.servPrestamo = servPrestamo;
    }

    public Documento getIdDocumentoTituloValor() {
        return idDocumentoTituloValor;
    }

    public void setIdDocumentoTituloValor(Documento idDocumentoTituloValor) {
        this.idDocumentoTituloValor = idDocumentoTituloValor;
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
        hash += (cuotaPK != null ? cuotaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.cuotaPK == null && other.cuotaPK != null) || (this.cuotaPK != null && !this.cuotaPK.equals(other.cuotaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Cuota[ cuotaPK=" + cuotaPK + " ]";
    }
    
}
