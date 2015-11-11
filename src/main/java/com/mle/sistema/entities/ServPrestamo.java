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
 * @author christian
 */
@Entity
@Table(name = "serv_prestamo", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServPrestamo.findAll", query = "SELECT s FROM ServPrestamo s"),
    @NamedQuery(name = "ServPrestamo.findByIdServPrestamo", query = "SELECT s FROM ServPrestamo s WHERE s.idServPrestamo = :idServPrestamo"),
    @NamedQuery(name = "ServPrestamo.findByMontoTotal", query = "SELECT s FROM ServPrestamo s WHERE s.montoTotal = :montoTotal"),
    @NamedQuery(name = "ServPrestamo.findByNumCuotas", query = "SELECT s FROM ServPrestamo s WHERE s.numCuotas = :numCuotas"),
    @NamedQuery(name = "ServPrestamo.findByFecharegistro", query = "SELECT s FROM ServPrestamo s WHERE s.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "ServPrestamo.findByMontocuota", query = "SELECT s FROM ServPrestamo s WHERE s.montocuota = :montocuota"),
    @NamedQuery(name = "ServPrestamo.findByFormaCobranza", query = "SELECT s FROM ServPrestamo s WHERE s.formaCobranza = :formaCobranza"),
    @NamedQuery(name = "ServPrestamo.findByTasaInteres", query = "SELECT s FROM ServPrestamo s WHERE s.tasaInteres = :tasaInteres"),
    @NamedQuery(name = "ServPrestamo.findByTipoMoneda", query = "SELECT s FROM ServPrestamo s WHERE s.tipoMoneda = :tipoMoneda"),
    @NamedQuery(name = "ServPrestamo.findByTipoMora", query = "SELECT s FROM ServPrestamo s WHERE s.tipoMora = :tipoMora"),
    @NamedQuery(name = "ServPrestamo.findByMontomora", query = "SELECT s FROM ServPrestamo s WHERE s.montomora = :montomora"),
    @NamedQuery(name = "ServPrestamo.findByEstado", query = "SELECT s FROM ServPrestamo s WHERE s.estado = :estado")})
public class ServPrestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idServ_Prestamo")
    private Integer idServPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto_Total")
    private float montoTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Num_Cuotas")
    private int numCuotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto_cuota")
    private float montocuota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Forma_Cobranza")
    private String formaCobranza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tasa_Interes")
    private float tasaInteres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo_Moneda")
    private Character tipoMoneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo_Mora")
    private String tipoMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto_mora")
    private float montomora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servPrestamo")
    private List<Cuota> cuotaList;
    @JoinColumn(name = "Deudor_idAval", referencedColumnName = "DNI")
    @ManyToOne
    private Deudor deudoridAval;
    @JoinColumn(name = "Deudor_idDeudor", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Deudor deudoridDeudor;
    @JoinColumn(name = "ClienteNatural_idCliente", referencedColumnName = "Cliente_idCliente")
    @ManyToOne(optional = false)
    private Clientenatural clienteNaturalidCliente;

    public ServPrestamo() {
    }

    public ServPrestamo(Integer idServPrestamo) {
        this.idServPrestamo = idServPrestamo;
    }

    public ServPrestamo(Integer idServPrestamo, float montoTotal, int numCuotas, Date fecharegistro, float montocuota, String formaCobranza, float tasaInteres, Character tipoMoneda, String tipoMora, float montomora, String estado) {
        this.idServPrestamo = idServPrestamo;
        this.montoTotal = montoTotal;
        this.numCuotas = numCuotas;
        this.fecharegistro = fecharegistro;
        this.montocuota = montocuota;
        this.formaCobranza = formaCobranza;
        this.tasaInteres = tasaInteres;
        this.tipoMoneda = tipoMoneda;
        this.tipoMora = tipoMora;
        this.montomora = montomora;
        this.estado = estado;
    }

    public Integer getIdServPrestamo() {
        return idServPrestamo;
    }

    public void setIdServPrestamo(Integer idServPrestamo) {
        this.idServPrestamo = idServPrestamo;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(int numCuotas) {
        this.numCuotas = numCuotas;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public float getMontocuota() {
        return montocuota;
    }

    public void setMontocuota(float montocuota) {
        this.montocuota = montocuota;
    }

    public String getFormaCobranza() {
        return formaCobranza;
    }

    public void setFormaCobranza(String formaCobranza) {
        this.formaCobranza = formaCobranza;
    }

    public float getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public Character getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(Character tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getTipoMora() {
        return tipoMora;
    }

    public void setTipoMora(String tipoMora) {
        this.tipoMora = tipoMora;
    }

    public float getMontomora() {
        return montomora;
    }

    public void setMontomora(float montomora) {
        this.montomora = montomora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
    }

    public Deudor getDeudoridAval() {
        return deudoridAval;
    }

    public void setDeudoridAval(Deudor deudoridAval) {
        this.deudoridAval = deudoridAval;
    }

    public Deudor getDeudoridDeudor() {
        return deudoridDeudor;
    }

    public void setDeudoridDeudor(Deudor deudoridDeudor) {
        this.deudoridDeudor = deudoridDeudor;
    }

    public Clientenatural getClienteNaturalidCliente() {
        return clienteNaturalidCliente;
    }

    public void setClienteNaturalidCliente(Clientenatural clienteNaturalidCliente) {
        this.clienteNaturalidCliente = clienteNaturalidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServPrestamo != null ? idServPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServPrestamo)) {
            return false;
        }
        ServPrestamo other = (ServPrestamo) object;
        if ((this.idServPrestamo == null && other.idServPrestamo != null) || (this.idServPrestamo != null && !this.idServPrestamo.equals(other.idServPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.ServPrestamo[ idServPrestamo=" + idServPrestamo + " ]";
    }
    
}
