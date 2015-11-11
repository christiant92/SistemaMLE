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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "deudor", catalog = "sistemamle", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deudor.findAll", query = "SELECT d FROM Deudor d"),
    @NamedQuery(name = "Deudor.findByDni", query = "SELECT d FROM Deudor d WHERE d.dni = :dni"),
    @NamedQuery(name = "Deudor.findByNombres", query = "SELECT d FROM Deudor d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "Deudor.findByApellidos", query = "SELECT d FROM Deudor d WHERE d.apellidos = :apellidos"),
    @NamedQuery(name = "Deudor.findByTelefono", query = "SELECT d FROM Deudor d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Deudor.findByDireccion", query = "SELECT d FROM Deudor d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Deudor.findByDistrito", query = "SELECT d FROM Deudor d WHERE d.distrito = :distrito"),
    @NamedQuery(name = "Deudor.findByProvincia", query = "SELECT d FROM Deudor d WHERE d.provincia = :provincia")})
public class Deudor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNI")
    private Integer dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Telefono")
    private Integer telefono;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "Distrito")
    private String distrito;
    @Size(max = 45)
    @Column(name = "Provincia")
    private String provincia;
    @OneToMany(mappedBy = "deudoridAval")
    private List<Pagare> pagareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deudoridDeudor")
    private List<Pagare> pagareList1;
    @OneToMany(mappedBy = "deudoridAval")
    private List<ServPrestamo> servPrestamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deudoridDeudor")
    private List<ServPrestamo> servPrestamoList1;

    public Deudor() {
    }

    public Deudor(Integer dni) {
        this.dni = dni;
    }

    public Deudor(Integer dni, String nombres, String apellidos) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<Pagare> getPagareList() {
        return pagareList;
    }

    public void setPagareList(List<Pagare> pagareList) {
        this.pagareList = pagareList;
    }

    @XmlTransient
    public List<Pagare> getPagareList1() {
        return pagareList1;
    }

    public void setPagareList1(List<Pagare> pagareList1) {
        this.pagareList1 = pagareList1;
    }

    @XmlTransient
    public List<ServPrestamo> getServPrestamoList() {
        return servPrestamoList;
    }

    public void setServPrestamoList(List<ServPrestamo> servPrestamoList) {
        this.servPrestamoList = servPrestamoList;
    }

    @XmlTransient
    public List<ServPrestamo> getServPrestamoList1() {
        return servPrestamoList1;
    }

    public void setServPrestamoList1(List<ServPrestamo> servPrestamoList1) {
        this.servPrestamoList1 = servPrestamoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deudor)) {
            return false;
        }
        Deudor other = (Deudor) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mle.sistema.entities.Deudor[ dni=" + dni + " ]";
    }
    
}
