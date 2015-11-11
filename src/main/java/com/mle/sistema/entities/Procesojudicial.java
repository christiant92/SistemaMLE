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
import javax.persistence.JoinColumns;
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
@Table(name = "procesojudicial", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesojudicial.findAll", query = "SELECT p FROM Procesojudicial p"),
    @NamedQuery(name = "Procesojudicial.findByNroExpediente", query = "SELECT p FROM Procesojudicial p WHERE p.nroExpediente = :nroExpediente"),
    @NamedQuery(name = "Procesojudicial.findByEspecialista", query = "SELECT p FROM Procesojudicial p WHERE p.especialista = :especialista"),
    @NamedQuery(name = "Procesojudicial.findByTipoProcesoJudicial", query = "SELECT p FROM Procesojudicial p WHERE p.tipoProcesoJudicial = :tipoProcesoJudicial"),
    @NamedQuery(name = "Procesojudicial.findByFPresentacionDemanda", query = "SELECT p FROM Procesojudicial p WHERE p.fPresentacionDemanda = :fPresentacionDemanda"),
    @NamedQuery(name = "Procesojudicial.findByFAdmisionDemanda", query = "SELECT p FROM Procesojudicial p WHERE p.fAdmisionDemanda = :fAdmisionDemanda"),
    @NamedQuery(name = "Procesojudicial.findByAvanceRegistros", query = "SELECT p FROM Procesojudicial p WHERE p.avanceRegistros = :avanceRegistros"),
    @NamedQuery(name = "Procesojudicial.findByEstado", query = "SELECT p FROM Procesojudicial p WHERE p.estado = :estado"),
    @NamedQuery(name = "Procesojudicial.findByTransado", query = "SELECT p FROM Procesojudicial p WHERE p.transado = :transado"),
    @NamedQuery(name = "Procesojudicial.findByArchivado", query = "SELECT p FROM Procesojudicial p WHERE p.archivado = :archivado")})
public class Procesojudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nro_Expediente")
    private String nroExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Especialista")
    private String especialista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Tipo_ProcesoJudicial")
    private String tipoProcesoJudicial;
    @Column(name = "F_Presentacion_Demanda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fPresentacionDemanda;
    @Column(name = "F_Admision_Demanda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fAdmisionDemanda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Avance_Registros")
    private String avanceRegistros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Transado")
    private boolean transado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Archivado")
    private boolean archivado;
    @JoinColumn(name = "Pagare_idPagare", referencedColumnName = "idPagare")
    @ManyToOne(optional = false)
    private Pagare pagareidPagare;
    @JoinColumn(name = "CodigoCautelar", referencedColumnName = "Codigo Cautelar")
    @ManyToOne
    private Medidacautelar codigoCautelar;
    @JoinColumns({
        @JoinColumn(name = "Juzgado_idJuzgado", referencedColumnName = "idJuzgado"),
        @JoinColumn(name = "Id_LugarJuzgado", referencedColumnName = "idLugarJuzgado")})
    @ManyToOne(optional = false)
    private Juzgado juzgado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesojudicial")
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesojudicial")
    private List<Programacion> programacionList;

    public Procesojudicial() {
    }

    public Procesojudicial(String nroExpediente) {
        this.nroExpediente = nroExpediente;
    }

    public Procesojudicial(String nroExpediente, String especialista, String tipoProcesoJudicial, String avanceRegistros, Character estado, boolean transado, boolean archivado) {
        this.nroExpediente = nroExpediente;
        this.especialista = especialista;
        this.tipoProcesoJudicial = tipoProcesoJudicial;
        this.avanceRegistros = avanceRegistros;
        this.estado = estado;
        this.transado = transado;
        this.archivado = archivado;
    }

    public String getNroExpediente() {
        return nroExpediente;
    }

    public void setNroExpediente(String nroExpediente) {
        this.nroExpediente = nroExpediente;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public String getTipoProcesoJudicial() {
        return tipoProcesoJudicial;
    }

    public void setTipoProcesoJudicial(String tipoProcesoJudicial) {
        this.tipoProcesoJudicial = tipoProcesoJudicial;
    }

    public Date getFPresentacionDemanda() {
        return fPresentacionDemanda;
    }

    public void setFPresentacionDemanda(Date fPresentacionDemanda) {
        this.fPresentacionDemanda = fPresentacionDemanda;
    }

    public Date getFAdmisionDemanda() {
        return fAdmisionDemanda;
    }

    public void setFAdmisionDemanda(Date fAdmisionDemanda) {
        this.fAdmisionDemanda = fAdmisionDemanda;
    }

    public String getAvanceRegistros() {
        return avanceRegistros;
    }

    public void setAvanceRegistros(String avanceRegistros) {
        this.avanceRegistros = avanceRegistros;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public boolean getTransado() {
        return transado;
    }

    public void setTransado(boolean transado) {
        this.transado = transado;
    }

    public boolean getArchivado() {
        return archivado;
    }

    public void setArchivado(boolean archivado) {
        this.archivado = archivado;
    }

    public Pagare getPagareidPagare() {
        return pagareidPagare;
    }

    public void setPagareidPagare(Pagare pagareidPagare) {
        this.pagareidPagare = pagareidPagare;
    }

    public Medidacautelar getCodigoCautelar() {
        return codigoCautelar;
    }

    public void setCodigoCautelar(Medidacautelar codigoCautelar) {
        this.codigoCautelar = codigoCautelar;
    }

    public Juzgado getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(Juzgado juzgado) {
        this.juzgado = juzgado;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Programacion> getProgramacionList() {
        return programacionList;
    }

    public void setProgramacionList(List<Programacion> programacionList) {
        this.programacionList = programacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroExpediente != null ? nroExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesojudicial)) {
            return false;
        }
        Procesojudicial other = (Procesojudicial) object;
        if ((this.nroExpediente == null && other.nroExpediente != null) || (this.nroExpediente != null && !this.nroExpediente.equals(other.nroExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Procesojudicial[ nroExpediente=" + nroExpediente + " ]";
    }
    
}
