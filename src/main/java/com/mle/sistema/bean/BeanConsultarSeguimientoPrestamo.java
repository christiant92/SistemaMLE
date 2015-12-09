/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.bean;

import com.mle.sistema.entities.Cuota;
import com.mle.sistema.entities.ServPrestamo;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.servicios.IFaceSeguimientoPrestamo;
import com.mle.sistema.util.Utilidades;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Oviguan
 */
public class BeanConsultarSeguimientoPrestamo implements Serializable {

    private IFaceSeguimientoPrestamo seguimientoPrestamoService;
    private BeanConsultarSeguimientoPrestamo bcsp;

    private List<Cuota> listaCuotas;
    private List<ServPrestamo> listaServPrestamos;
    private String mensaje_Cuotas;
    private String mensaje_ServPrestamo;
    private String txt_idServ_Prestamo;

    public BeanConsultarSeguimientoPrestamo() {
    }

    public String buscarServPrestamos() throws IOException {
        listaServPrestamos = null;
        try {
            listaServPrestamos = seguimientoPrestamoService.buscarServPrestamos(this);
            listaCuotas=listaServPrestamos.get(0).getCuotaList();
            Utilidades.addMsgInfo("Mensaje", getMensaje_ServPrestamo());
        } catch (MLEException ex) {
            Utilidades.addMsgError("Error en validar usuario.", ex.getMsgException());
        }

        return "consSegPres_PC";
    }

    public BeanConsultarSeguimientoPrestamo getBcsp() {
        return bcsp;
    }

    public void setBcsp(BeanConsultarSeguimientoPrestamo bcsp) {
        this.bcsp = bcsp;
    }

    public List<ServPrestamo> getListaServPrestamos() {
        return listaServPrestamos;
    }

    public void setListaServPrestamos(List<ServPrestamo> listaServPrestamos) {
        this.listaServPrestamos = listaServPrestamos;
    }

    public String getTxt_idServ_Prestamo() {
        return txt_idServ_Prestamo;
    }

    public void setTxt_idServ_Prestamo(String txt_idServ_Prestamo) {
        this.txt_idServ_Prestamo = txt_idServ_Prestamo;
    }

    
    
    public String getMensaje_Cuotas() {
        return mensaje_Cuotas;
    }

    public void setMensaje_Cuotas(String mensaje_Cuotas) {
        this.mensaje_Cuotas = mensaje_Cuotas;
    }

    public String getMensaje_ServPrestamo() {
        return mensaje_ServPrestamo;
    }

    public void setMensaje_ServPrestamo(String mensaje_ServPrestamo) {
        this.mensaje_ServPrestamo = mensaje_ServPrestamo;
    }

    public IFaceSeguimientoPrestamo getSeguimientoPrestamoService() {
        return seguimientoPrestamoService;
    }

    public void setSeguimientoPrestamoService(IFaceSeguimientoPrestamo seguimientoPrestamoService) {
        this.seguimientoPrestamoService = seguimientoPrestamoService;
    }

    public List<Cuota> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(List<Cuota> listaCuotas) {
        this.listaCuotas = listaCuotas;
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
        final BeanConsultarSeguimientoPrestamo other = (BeanConsultarSeguimientoPrestamo) obj;
        if (!Objects.equals(this.seguimientoPrestamoService, other.seguimientoPrestamoService)) {
            return false;
        }
        return true;
    }

}
