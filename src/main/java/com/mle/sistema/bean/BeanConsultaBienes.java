/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.bean;

import com.mle.sistema.exception.MLEException;
import com.mle.sistema.servicios.IFaceBienes;
import com.mle.sistema.servicios.IFaceConsultaBienes;
import com.mle.sistema.util.Utilidades;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Christian
 */
@ManagedBean(name="beanConsultaBienes")
@ViewScoped
public class BeanConsultaBienes {
    private Integer nroPartidaBuscar;
    
    //atributos de bien
    private Integer nroPartida;
    private String tipoBien;
    private String ubicacion;
    private Float montoVal;
    private String tipoProp;
    private String desc;
    private String mensaje;
    
    @ManagedProperty("#{serviceConsultaBienes}")
    private IFaceConsultaBienes consultaBienesService;

    public Integer getNroPartidaBuscar() {
        return nroPartidaBuscar;
    }

    public void setNroPartidaBuscar(Integer nroPartidaBuscar) {
        this.nroPartidaBuscar = nroPartidaBuscar;
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

    public Float getMontoVal() {
        return montoVal;
    }

    public void setMontoVal(Float montoVal) {
        this.montoVal = montoVal;
    }

    public String getTipoProp() {
        return tipoProp;
    }

    public void setTipoProp(String tipoProp) {
        this.tipoProp = tipoProp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public IFaceConsultaBienes getConsultaBienesService() {
        return consultaBienesService;
    }

    public void setConsultaBienesService(IFaceConsultaBienes consultaBienesService) {
        this.consultaBienesService = consultaBienesService;
    }
    
    public void consultarBien() {
        try {
            consultaBienesService.consultarBien(this);
            Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            Utilidades.addMsgError("Error en obtener bienes.", e.getMsgException());
        }
        
    }
    
}
