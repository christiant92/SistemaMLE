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
@Table(name = "clientenatural", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientenatural.findAll", query = "SELECT c FROM Clientenatural c"),
    @NamedQuery(name = "Clientenatural.findByClienteidCliente", query = "SELECT c FROM Clientenatural c WHERE c.clienteidCliente = :clienteidCliente"),
    @NamedQuery(name = "Clientenatural.findByDni", query = "SELECT c FROM Clientenatural c WHERE c.dni = :dni"),
    @NamedQuery(name = "Clientenatural.findByNombres", query = "SELECT c FROM Clientenatural c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Clientenatural.findByApellidos", query = "SELECT c FROM Clientenatural c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Clientenatural.findByCelular", query = "SELECT c FROM Clientenatural c WHERE c.celular = :celular"),
    @NamedQuery(name = "Clientenatural.findByCuentaDeposito", query = "SELECT c FROM Clientenatural c WHERE c.cuentaDeposito = :cuentaDeposito")})
public class Clientenatural implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cliente_idCliente")
    private Integer clienteidCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNI")
    private int dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Celular")
    private Integer celular;
    @Size(max = 45)
    @Column(name = "CuentaDeposito")
    private String cuentaDeposito;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteNaturalidCliente")
    private List<ServPrestamo> servPrestamoList;

    public Clientenatural() {
    }

    public Clientenatural(Integer clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Clientenatural(Integer clienteidCliente, int dni, String nombres, String apellidos) {
        this.clienteidCliente = clienteidCliente;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Integer clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getCuentaDeposito() {
        return cuentaDeposito;
    }

    public void setCuentaDeposito(String cuentaDeposito) {
        this.cuentaDeposito = cuentaDeposito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public List<ServPrestamo> getServPrestamoList() {
        return servPrestamoList;
    }

    public void setServPrestamoList(List<ServPrestamo> servPrestamoList) {
        this.servPrestamoList = servPrestamoList;
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
        if (!(object instanceof Clientenatural)) {
            return false;
        }
        Clientenatural other = (Clientenatural) object;
        if ((this.clienteidCliente == null && other.clienteidCliente != null) || (this.clienteidCliente != null && !this.clienteidCliente.equals(other.clienteidCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Clientenatural[ clienteidCliente=" + clienteidCliente + " ]";
    }
    
}
