/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "rol", catalog = "sistemamle_controldeusuarios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.rolPK.idRol = :idRol"),
    @NamedQuery(name = "Rol.findBySistemaidSistema", query = "SELECT r FROM Rol r WHERE r.rolPK.sistemaidSistema = :sistemaidSistema"),
    @NamedQuery(name = "Rol.findByNombreRol", query = "SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolPK rolPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NombreRol")
    private String nombreRol;
    @JoinTable(name = "usuario_rol", joinColumns = {
        @JoinColumn(name = "Rol_idRol", referencedColumnName = "idRol"),
        @JoinColumn(name = "Rol_Sistema_idSistema", referencedColumnName = "Sistema_idSistema")}, inverseJoinColumns = {
        @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinTable(name = "rol_subopcion", joinColumns = {
        @JoinColumn(name = "Rol_idRol", referencedColumnName = "idRol"),
        @JoinColumn(name = "Rol_Sistema_idSistema", referencedColumnName = "Sistema_idSistema")}, inverseJoinColumns = {
        @JoinColumn(name = "SubOpcion_idSubOpcion", referencedColumnName = "idSubOpcion"),
        @JoinColumn(name = "SubOpcion_Opcion_idOpcion", referencedColumnName = "Opcion_idOpcion")})
    @ManyToMany
    private List<Subopcion> subopcionList;
    @JoinColumn(name = "Sistema_idSistema", referencedColumnName = "idSistema", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sistema sistema;

    public Rol() {
    }

    public Rol(RolPK rolPK) {
        this.rolPK = rolPK;
    }

    public Rol(RolPK rolPK, String nombreRol) {
        this.rolPK = rolPK;
        this.nombreRol = nombreRol;
    }

    public Rol(int idRol, int sistemaidSistema) {
        this.rolPK = new RolPK(idRol, sistemaidSistema);
    }

    public RolPK getRolPK() {
        return rolPK;
    }

    public void setRolPK(RolPK rolPK) {
        this.rolPK = rolPK;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Subopcion> getSubopcionList() {
        return subopcionList;
    }

    public void setSubopcionList(List<Subopcion> subopcionList) {
        this.subopcionList = subopcionList;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolPK != null ? rolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolPK == null && other.rolPK != null) || (this.rolPK != null && !this.rolPK.equals(other.rolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Rol[ rolPK=" + rolPK + " ]";
    }
    
}
