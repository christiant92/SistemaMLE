/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.bean;

import com.mle.sistema.entities.Clientenatural;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.servicios.IFaceSeguimientoPrestamo;
import com.mle.sistema.util.Utilidades;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oviguan
 */
public class BeanRegistrarSeguimientoPrestamo implements Serializable {

    private IFaceSeguimientoPrestamo seguimientoPrestamoService;
    private Integer idServ_Prestamo;
    
    private String Nombres_prestatario;
    private String Apellidos_prestatario;
    private Integer DNI_prestatario;
    private String Teléfono_prestatario;
    private String Dirección_prestatario;

    private String Nombres_prestamista;
    private String Apellidos_prestamista;
    private Integer DNI_prestamista;
    private String Teléfono_prestamista;
    private String Dirección_prestamista;

    private Integer DNI_Aval;
    private String ApellidosNombres_Aval;
    
    private String MontoPrestamo;
    private String TasaInteres;
    private String NroCuotas;
    private String MontoCuota;
    private String FormaCobranza;
    private String TipoMoneda;
    private String PeriodoCobranza;
    private Date FechaInicialPago;

    private String mensajePrestatario;
    private String mensajePrestamista;
    private String mensajeServPrestamo;
    
    private BeanRegistrarSeguimientoPrestamo bsp;
    private List<Clientenatural> listaClientes;
    private List<Deudor> listaDeudor;
    private List<Deudor> listaAval;

    public BeanRegistrarSeguimientoPrestamo getBsp() {
        return bsp;
    }

    public void setBsp(BeanRegistrarSeguimientoPrestamo bsp) {
        this.bsp = bsp;
    }
    
    public BeanRegistrarSeguimientoPrestamo() {
    }

    
    public String validarPrestamista() throws IOException {
        try {
            seguimientoPrestamoService.validarPrestamista(this);
            Utilidades.addMsgInfo("Mensaje", getMensajePrestamista());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "regSegPres";
    }
    
    public String validarPrestamista1() throws IOException {
        listaClientes=null;
        try {
           listaClientes = seguimientoPrestamoService.validarPrestamista1(this);
            Utilidades.addMsgInfo("Mensaje", getMensajePrestamista());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "regSegPres";
    }
    
    public String validarPrestatario() throws IOException {
        try {
            seguimientoPrestamoService.validarPrestatario(this);
            Utilidades.addMsgInfo("Mensaje", getMensajePrestatario());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "regSegPres";
    }

     public String validarPrestatario1() throws IOException {
        try {
            listaDeudor=seguimientoPrestamoService.validarPrestatario1(this);
            Utilidades.addMsgInfo("Mensaje", getMensajePrestatario());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "regSegPres";
    }
    
    public String validarAval() throws IOException {
        try {
            seguimientoPrestamoService.validarAval(this);
            Utilidades.addMsgInfo("Mensaje", getMensajePrestatario());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "regSegPres";
    }
    
    public String validarAval1() throws IOException {
        try {
            listaAval= seguimientoPrestamoService.validarAval1(this);
            Utilidades.addMsgInfo("Mensaje", getMensajePrestatario());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "regSegPres";
    }
    
    public String buscarSeguimientoPrestamo() throws IOException {
        try {
            seguimientoPrestamoService.buscarSeguimientoPrestamo(this);
            Utilidades.addMsgInfo("Mensaje", getMensajeServPrestamo());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "consSegPres_A";
    }

    public String registrarSeguimientoPrestamo() throws IOException {
        try {
            seguimientoPrestamoService.registrarSeguimientoPrestamo(this);
            Utilidades.addMsgInfo("Mensaje", getMensajePrestatario());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        //return "modSegPres";
        return "regSegPres";
    }

    
    

    
    
    public String getMensajePrestatario() {
        return mensajePrestatario;
    }

    public void setMensajePrestatario(String mensajePrestatario) {
        this.mensajePrestatario = mensajePrestatario;
    }

    public String getMensajePrestamista() {
        return mensajePrestamista;
    }

    public void setMensajePrestamista(String mensajePrestamista) {
        this.mensajePrestamista = mensajePrestamista;
    }

    public String getNombres_prestatario() {
        return Nombres_prestatario;
    }

    public void setNombres_prestatario(String Nombres_prestatario) {
        this.Nombres_prestatario = Nombres_prestatario;
    }

    public String getApellidos_prestatario() {
        return Apellidos_prestatario;
    }

    public void setApellidos_prestatario(String Apellidos_prestatario) {
        this.Apellidos_prestatario = Apellidos_prestatario;
    }

    public Integer getDNI_prestatario() {
        return DNI_prestatario;
    }

    public void setDNI_prestatario(Integer DNI_prestatario) {
        this.DNI_prestatario = DNI_prestatario;
    }

    public String getTeléfono_prestatario() {
        return Teléfono_prestatario;
    }

    public void setTeléfono_prestatario(String Teléfono_prestatario) {
        this.Teléfono_prestatario = Teléfono_prestatario;
    }

    public String getDirección_prestatario() {
        return Dirección_prestatario;
    }

    public void setDirección_prestatario(String Dirección_prestatario) {
        this.Dirección_prestatario = Dirección_prestatario;
    }
    
    public IFaceSeguimientoPrestamo getSeguimientoPrestamoService() {
        return seguimientoPrestamoService;
    }

    public void setSeguimientoPrestamoService(IFaceSeguimientoPrestamo seguimientoPrestamoService) {
        this.seguimientoPrestamoService = seguimientoPrestamoService;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.seguimientoPrestamoService);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BeanRegistrarSeguimientoPrestamo other = (BeanRegistrarSeguimientoPrestamo) obj;
        if (!Objects.equals(this.seguimientoPrestamoService, other.seguimientoPrestamoService)) {
            return false;
        }
        return true;
    }

    public String getNombres_prestamista() {
        return Nombres_prestamista;
    }

    public void setNombres_prestamista(String Nombres_prestamista) {
        this.Nombres_prestamista = Nombres_prestamista;
    }

    public String getApellidos_prestamista() {
        return Apellidos_prestamista;
    }

    public void setApellidos_prestamista(String Apellidos_prestamista) {
        this.Apellidos_prestamista = Apellidos_prestamista;
    }

    public Integer getDNI_prestamista() {
        return DNI_prestamista;
    }

    public void setDNI_prestamista(Integer DNI_prestamista) {
        this.DNI_prestamista = DNI_prestamista;
    }

    public String getTeléfono_prestamista() {
        return Teléfono_prestamista;
    }

    public void setTeléfono_prestamista(String Teléfono_prestamista) {
        this.Teléfono_prestamista = Teléfono_prestamista;
    }

    public String getDirección_prestamista() {
        return Dirección_prestamista;
    }

    public void setDirección_prestamista(String Dirección_prestamista) {
        this.Dirección_prestamista = Dirección_prestamista;
    }

    public String getMontoPrestamo() {
        return MontoPrestamo;
    }

    public void setMontoPrestamo(String MontoPrestamo) {
        this.MontoPrestamo = MontoPrestamo;
    }

    public String getTasaInteres() {
        return TasaInteres;
    }

    public void setTasaInteres(String TasaInteres) {
        this.TasaInteres = TasaInteres;
    }

    public String getNroCuotas() {
        return NroCuotas;
    }

    public void setNroCuotas(String NroCuotas) {
        this.NroCuotas = NroCuotas;
    }

    public String getMontoCuota() {
        return MontoCuota;
    }

    public void setMontoCuota(String MontoCuota) {
        this.MontoCuota = MontoCuota;
    }

    public String getFormaCobranza() {
        return FormaCobranza;
    }

    public void setFormaCobranza(String FormaCobranza) {
        this.FormaCobranza = FormaCobranza;
    }

    public String getTipoMoneda() {
        return TipoMoneda;
    }

    public void setTipoMoneda(String TipoMoneda) {
        this.TipoMoneda = TipoMoneda;
    }

    public String getPeriodoCobranza() {
        return PeriodoCobranza;
    }

    public void setPeriodoCobranza(String PeriodoCobranza) {
        this.PeriodoCobranza = PeriodoCobranza;
    }

    public Date getFechaInicialPago() {
        return FechaInicialPago;
    }

    public void setFechaInicialPago(Date FechaInicialPago) {
        this.FechaInicialPago = FechaInicialPago;
    }

    public Integer getDNI_Aval() {
        return DNI_Aval;
    }

    public void setDNI_Aval(Integer DNI_Aval) {
        this.DNI_Aval = DNI_Aval;
    }

    public String getApellidosNombres_Aval() {
        return ApellidosNombres_Aval;
    }

    public void setApellidosNombres_Aval(String ApellidosNombres_Aval) {
        this.ApellidosNombres_Aval = ApellidosNombres_Aval;
    }

    public Integer getIdServ_Prestamo() {
        return idServ_Prestamo;
    }

    public void setIdServ_Prestamo(Integer idServ_Prestamo) {
        this.idServ_Prestamo = idServ_Prestamo;
    }

    public String getMensajeServPrestamo() {
        return mensajeServPrestamo;
    }

    public void setMensajeServPrestamo(String mensajeServPrestamo) {
        this.mensajeServPrestamo = mensajeServPrestamo;
    }

    public List<Clientenatural> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Clientenatural> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Deudor> getListaDeudor() {
        return listaDeudor;
    }

    public void setListaDeudor(List<Deudor> listaDeudor) {
        this.listaDeudor = listaDeudor;
    }

    public List<Deudor> getListaAval() {
        return listaAval;
    }

    public void setListaAval(List<Deudor> listaAval) {
        this.listaAval = listaAval;
    }

    
    
    
}
