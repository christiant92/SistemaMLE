/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "clientejuridico", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientejuridico.findAll", query = "SELECT c FROM Clientejuridico c"),
    @NamedQuery(name = "Clientejuridico.findByClienteidCliente", query = "SELECT c FROM Clientejuridico c WHERE c.clienteidCliente = :clienteidCliente"),
    @NamedQuery(name = "Clientejuridico.findByRuc", query = "SELECT c FROM Clientejuridico c WHERE c.ruc = :ruc"),
    @NamedQuery(name = "Clientejuridico.findByRazonSocial", query = "SELECT c FROM Clientejuridico c WHERE c.razonSocial = :razonSocial")})
public class Clientejuridico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cliente_idCliente")
    private Integer clienteidCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUC")
    private int ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Razon Social")
    private String razonSocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private List<Pagare> pagareList;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;

    public Clientejuridico() {
    }

    public Clientejuridico(Integer clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Clientejuridico(Integer clienteidCliente, int ruc, String razonSocial) {
        this.clienteidCliente = clienteidCliente;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

    public Integer getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Integer clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @XmlTransient
    public List<Pagare> getPagareList() {
        return pagareList;
    }

    public void setPagareList(List<Pagare> pagareList) {
        this.pagareList = pagareList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteidCliente != null ? clienteidCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientejuridico)) {
            return false;
        }
        Clientejuridico other = (Clientejuridico) object;
        if ((this.clienteidCliente == null && other.clienteidCliente != null) || (this.clienteidCliente != null && !this.clienteidCliente.equals(other.clienteidCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Clientejuridico[ clienteidCliente=" + clienteidCliente + " ]";
    }
    
}
