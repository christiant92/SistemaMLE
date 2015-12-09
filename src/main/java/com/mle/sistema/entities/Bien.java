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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Christian
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nro_Partida")
    private int nroPartida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Tipo_Bien")
    private String tipoBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto_Valorizado")
    private float montoValorizado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo_Propietario")
    private String tipoPropietario;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bien")
    private List<BienMedidacautelar> bienMedidacautelarList;
    @Null
    @JoinColumn(name = "Id_Documento", referencedColumnName = "idDocumento")
    @ManyToOne
    private Documento idDocumento;

    public Bien() {
    }

    public Bien(Integer idBien) {
        this.idBien = idBien;
    }

    public Bien(Integer idBien, int nroPartida, String tipoBien, String ubicacion, float montoValorizado, String tipoPropietario) {
        this.idBien = idBien;
        this.nroPartida = nroPartida;
        this.tipoBien = tipoBien;
        this.ubicacion = ubicacion;
        this.montoValorizado = montoValorizado;
        this.tipoPropietario = tipoPropietario;
    }

    public Integer getIdBien() {
        return idBien;
    }

    public void setIdBien(Integer idBien) {
        this.idBien = idBien;
    }

    public int getNroPartida() {
        return nroPartida;
    }

    public void setNroPartida(int nroPartida) {
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

    public float getMontoValorizado() {
        return montoValorizado;
    }

    public void setMontoValorizado(float montoValorizado) {
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
