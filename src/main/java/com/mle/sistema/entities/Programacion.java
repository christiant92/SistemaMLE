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
 * @author christian
 */
@Entity
@Table(name = "programacion", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programacion.findAll", query = "SELECT p FROM Programacion p"),
    @NamedQuery(name = "Programacion.findByIdProgramacion", query = "SELECT p FROM Programacion p WHERE p.programacionPK.idProgramacion = :idProgramacion"),
    @NamedQuery(name = "Programacion.findByNroExpediente", query = "SELECT p FROM Programacion p WHERE p.programacionPK.nroExpediente = :nroExpediente"),
    @NamedQuery(name = "Programacion.findByFechaprogramada", query = "SELECT p FROM Programacion p WHERE p.fechaprogramada = :fechaprogramada"),
    @NamedQuery(name = "Programacion.findByEstado", query = "SELECT p FROM Programacion p WHERE p.estado = :estado")})
public class Programacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramacionPK programacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_programada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaprogramada;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Descripcion_Tareas")
    private String descripcionTareas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private Character estado;
    @JoinColumn(name = "Nro_Expediente", referencedColumnName = "Nro_Expediente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Procesojudicial procesojudicial;

    public Programacion() {
    }

    public Programacion(ProgramacionPK programacionPK) {
        this.programacionPK = programacionPK;
    }

    public Programacion(ProgramacionPK programacionPK, Date fechaprogramada, String descripcionTareas, Character estado) {
        this.programacionPK = programacionPK;
        this.fechaprogramada = fechaprogramada;
        this.descripcionTareas = descripcionTareas;
        this.estado = estado;
    }

    public Programacion(int idProgramacion, String nroExpediente) {
        this.programacionPK = new ProgramacionPK(idProgramacion, nroExpediente);
    }

    public ProgramacionPK getProgramacionPK() {
        return programacionPK;
    }

    public void setProgramacionPK(ProgramacionPK programacionPK) {
        this.programacionPK = programacionPK;
    }

    public Date getFechaprogramada() {
        return fechaprogramada;
    }

    public void setFechaprogramada(Date fechaprogramada) {
        this.fechaprogramada = fechaprogramada;
    }

    public String getDescripcionTareas() {
        return descripcionTareas;
    }

    public void setDescripcionTareas(String descripcionTareas) {
        this.descripcionTareas = descripcionTareas;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
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
        hash += (programacionPK != null ? programacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programacion)) {
            return false;
        }
        Programacion other = (Programacion) object;
        if ((this.programacionPK == null && other.programacionPK != null) || (this.programacionPK != null && !this.programacionPK.equals(other.programacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Programacion[ programacionPK=" + programacionPK + " ]";
    }
    
}
