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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "bien", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bien.findAll", query = "SELECT b FROM Bien b"),
    @NamedQuery(name = "Bien.findByIdBien", query = "SELECT b FROM Bien b WHERE b.idBien = :idBien"),
    @NamedQuery(name = "Bien.findByNroPartida", query = "SELECT b FROM Bien b WHERE b.nroPartida = :nroPartida"),
    @NamedQuery(name = "Bien.findByTipoBien", query = "SELECT b FROM Bien b WHERE b.tipoBien = :tipoBien"),
    @NamedQuery(name = "Bien.findByUbicacion", query = "SELECT b FROM Bien b WHERE b.ubicacion = :ubicacion"),
    @NamedQuery(name = "Bien.findByMontoValorizado", query = "SELECT b FROM Bien b WHERE b.montoValorizado = :montoValorizado"),
    @NamedQuery(name = "Bien.findByTipoPropietario", query = "SELECT b FROM Bien b WHERE b.tipoPropietario = :tipoPropietario"),
    @NamedQuery(name = "Bien.findByDescripcion", query = "SELECT b FROM Bien b WHERE b.descripcion = :descripcion")})
public class Bien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBien")
    private Integer idBien;
    @Column(name = "Nro_Partida")
    private Integer nroPartida;
    @Size(max = 30)
    @Column(name = "Tipo_Bien")
    private String tipoBien;
    @Size(max = 45)
    @Column(name = "Ubicacion")
    private String ubicacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Monto_Valorizado")
    private Float montoValorizado;
    @Size(max = 45)
    @Column(name = "Tipo_Propietario")
    private String tipoPropietario;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bien")
    private List<BienMedidacautelar> bienMedidacautelarList;
    @JoinColumn(name = "Id_Documento", referencedColumnName = "idDocumento")
    @ManyToOne(optional = false)
    private Documento idDocumento;

    public Bien() {
    }

    public Bien(Integer idBien) {
        this.idBien = idBien;
    }

    public Integer getIdBien() {
        return idBien;
    }

    public void setIdBien(Integer idBien) {
        this.idBien = idBien;
    }

    public Integer getNroPartida() {
        return nroPartida;
    }

    public void setNroPartida(Integer nroPartida) {
        this.nroPartida = nroPartida;
    }

    public String getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(String tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Float getMontoValorizado() {
        return montoValorizado;
    }

    public void setMontoValorizado(Float montoValorizado) {
        this.montoValorizado = montoValorizado;
    }

    public String getTipoPropietario() {
        return tipoPropietario;
    }

    public void setTipoPropietario(String tipoPropietario) {
        this.tipoPropietario = tipoPropietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<BienMedidacautelar> getBienMedidacautelarList() {
        return bienMedidacautelarList;
    }

    public void setBienMedidacautelarList(List<BienMedidacautelar> bienMedidacautelarList) {
        this.bienMedidacautelarList = bienMedidacautelarList;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBien != null ? idBien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bien)) {
            return false;
        }
        Bien other = (Bien) object;
        if ((this.idBien == null && other.idBien != null) || (this.idBien != null && !this.idBien.equals(other.idBien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Bien[ idBien=" + idBien + " ]";
    }
    
}
