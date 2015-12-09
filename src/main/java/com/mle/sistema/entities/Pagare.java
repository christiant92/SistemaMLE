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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Christian
 */
@Entity
@Table(name = "pagare", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagare.findAll", query = "SELECT p FROM Pagare p"),
    @NamedQuery(name = "Pagare.findByIdPagare", query = "SELECT p FROM Pagare p WHERE p.idPagare = :idPagare"),
    @NamedQuery(name = "Pagare.findByNumPagare", query = "SELECT p FROM Pagare p WHERE p.numPagare = :numPagare"),
    @NamedQuery(name = "Pagare.findByCodCredito", query = "SELECT p FROM Pagare p WHERE p.codCredito = :codCredito"),
    @NamedQuery(name = "Pagare.findByCodDeudor", query = "SELECT p FROM Pagare p WHERE p.codDeudor = :codDeudor"),
    @NamedQuery(name = "Pagare.findBySaldoCapital", query = "SELECT p FROM Pagare p WHERE p.saldoCapital = :saldoCapital"),
    @NamedQuery(name = "Pagare.findBySaldoCuota", query = "SELECT p FROM Pagare p WHERE p.saldoCuota = :saldoCuota"),
    @NamedQuery(name = "Pagare.findByDiasMora", query = "SELECT p FROM Pagare p WHERE p.diasMora = :diasMora"),
    @NamedQuery(name = "Pagare.findByFechaPrestamo", query = "SELECT p FROM Pagare p WHERE p.fechaPrestamo = :fechaPrestamo"),
    @NamedQuery(name = "Pagare.findBySituacionContractual", query = "SELECT p FROM Pagare p WHERE p.situacionContractual = :situacionContractual")})
public class Pagare implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPagare")
    private Integer idPagare;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Num_Pagare")
    private int numPagare;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cod_Credito")
    private String codCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cod_Deudor")
    private String codDeudor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saldo_Capital")
    private float saldoCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saldo_Cuota")
    private float saldoCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dias_Mora")
    private int diasMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Prestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Size(max = 20)
    @Column(name = "Situacion_Contractual")
    private String situacionContractual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagareidPagare")
    private List<Procesojudicial> procesojudicialList;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "Cliente_idCliente")
    @ManyToOne(optional = false)
    private Clientejuridico clienteidCliente;
    @JoinColumn(name = "Deudor_idDeudor", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Deudor deudoridDeudor;
    @JoinColumn(name = "Deudor_idAval", referencedColumnName = "DNI")
    @ManyToOne
    private Deudor deudoridAval;
    @JoinColumn(name = "Documento_idDocumento", referencedColumnName = "idDocumento")
    @ManyToOne
    private Documento documentoidDocumento;

    public Pagare() {
    }

    public Pagare(Integer idPagare) {
        this.idPagare = idPagare;
    }

    public Pagare(Integer idPagare, int numPagare, String codCredito, String codDeudor, float saldoCapital, float saldoCuota, int diasMora, Date fechaPrestamo) {
        this.idPagare = idPagare;
        this.numPagare = numPagare;
        this.codCredito = codCredito;
        this.codDeudor = codDeudor;
        this.saldoCapital = saldoCapital;
        this.saldoCuota = saldoCuota;
        this.diasMora = diasMora;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Integer getIdPagare() {
        return idPagare;
    }

    public void setIdPagare(Integer idPagare) {
        this.idPagare = idPagare;
    }

    public int getNumPagare() {
        return numPagare;
    }

    public void setNumPagare(int numPagare) {
        this.numPagare = numPagare;
    }

    public String getCodCredito() {
        return codCredito;
    }

    public void setCodCredito(String codCredito) {
        this.codCredito = codCredito;
    }

    public String getCodDeudor() {
        return codDeudor;
    }

    public void setCodDeudor(String codDeudor) {
        this.codDeudor = codDeudor;
    }

    public float getSaldoCapital() {
        return saldoCapital;
    }

    public void setSaldoCapital(float saldoCapital) {
        this.saldoCapital = saldoCapital;
    }

    public float getSaldoCuota() {
        return saldoCuota;
    }

    public void setSaldoCuota(float saldoCuota) {
        this.saldoCuota = saldoCuota;
    }

    public int getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(int diasMora) {
        this.diasMora = diasMora;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getSituacionContractual() {
        return situacionContractual;
    }

    public void setSituacionContractual(String situacionContractual) {
        this.situacionContractual = situacionContractual;
    }

    @XmlTransient
    public List<Procesojudicial> getProcesojudicialList() {
        return procesojudicialList;
    }

    public void setProcesojudicialList(List<Procesojudicial> procesojudicialList) {
        this.procesojudicialList = procesojudicialList;
    }

    public Clientejuridico getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Clientejuridico clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Deudor getDeudoridDeudor() {
        return deudoridDeudor;
    }

    public void setDeudoridDeudor(Deudor deudoridDeudor) {
        this.deudoridDeudor = deudoridDeudor;
    }

    public Deudor getDeudoridAval() {
        return deudoridAval;
    }

    public void setDeudoridAval(Deudor deudoridAval) {
        this.deudoridAval = deudoridAval;
    }

    public Documento getDocumentoidDocumento() {
        return documentoidDocumento;
    }

    public void setDocumentoidDocumento(Documento documentoidDocumento) {
        this.documentoidDocumento = documentoidDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagare != null ? idPagare.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagare)) {
            return false;
        }
        Pagare other = (Pagare) object;
        if ((this.idPagare == null && other.idPagare != null) || (this.idPagare != null && !this.idPagare.equals(other.idPagare))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Pagare[ idPagare=" + idPagare + " ]";
    }
    
}
