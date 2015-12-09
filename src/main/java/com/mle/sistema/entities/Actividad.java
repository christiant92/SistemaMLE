/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "actividad", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.actividadPK.idActividad = :idActividad"),
    @NamedQuery(name = "Actividad.findByNroExpediente", query = "SELECT a FROM Actividad a WHERE a.actividadPK.nroExpediente = :nroExpediente"),
    @NamedQuery(name = "Actividad.findByFecha", query = "SELECT a FROM Actividad a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Actividad.findByTipoActividadJudicial", query = "SELECT a FROM Actividad a WHERE a.tipoActividadJudicial = :tipoActividadJudicial")})
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActividadPK actividadPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Tipo_Actividad_Judicial")
    private String tipoActividadJudicial;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Nro_Expediente", referencedColumnName = "Nro_Expediente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Procesojudicial procesojudicial;

    public Actividad() {
    }

    public Actividad(ActividadPK actividadPK) {
        this.actividadPK = actividadPK;
    }

    public Actividad(ActividadPK actividadPK, Date fecha, String tipoActividadJudicial, String descripcion) {
        this.actividadPK = actividadPK;
        this.fecha = fecha;
        this.tipoActividadJudicial = tipoActividadJudicial;
        this.descripcion = descripcion;
    }

    public Actividad(int idActividad, String nroExpediente) {
        this.actividadPK = new ActividadPK(idActividad, nroExpediente);
    }

    public ActividadPK getActividadPK() {
        return actividadPK;
    }

    public void setActividadPK(ActividadPK actividadPK) {
        this.actividadPK = actividadPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoActividadJudicial() {
        return tipoActividadJudicial;
    }

    public void setTipoActividadJudicial(String tipoActividadJudicial) {
        this.tipoActividadJudicial = tipoActividadJudicial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Procesojudicial getProcesojudicial() {
        return procesojudicial;
    }

    public void setProcesojudicial(Procesojudicial procesojudicial) {
        this.procesojudicial = procesojudicial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadPK != null ? actividadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actividadPK == null && other.actividadPK != null) || (this.actividadPK != null && !this.actividadPK.equals(other.actividadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Actividad[ actividadPK=" + actividadPK + " ]";
    }
    
}
