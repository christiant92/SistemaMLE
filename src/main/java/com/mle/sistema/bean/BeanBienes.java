/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.bean;
 
import com.mle.sistema.entities.Bien;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.servicios.IFaceBienes;
import com.mle.sistema.util.Utilidades;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean(name="beanBienes")
@ViewScoped
public class BeanBienes implements Serializable {
    //atributos de bien
    private Integer nroPartida;
    private String tipoBien;
    private String ubicacion;
    private Float montoVal;
    private String tipoProp;
    private String desc;
    
    private String mensaje;
    //private Bien bienSeleccionado;
    private List<Bien> bienes;
    
    //chekbox tipoBienes
    //private String tipoBien;
    private Map<String,String> tipoBienes;
    //checkbox tipoPropietario
    //private String tipoProp;
    private Map<String,String> tipoProps;
    
    @ManagedProperty("#{serviceBienes}")
    private IFaceBienes bienesService;
 
    @PostConstruct
    public void init() {
        //inicializa checkbox
        tipoBienes  = new HashMap<>();
        tipoBienes.put("Mueble", "Mueble");
        tipoBienes.put("Inmueble", "Inmueble");
        tipoProps  = new HashMap<>();
        tipoProps.put("Sociedad Conyugal", "Sociedad Conyugal");
        tipoProps.put("Compartida", "Compartida");
        tipoProps.put("Exclusivo", "Exclusivo");
                
        //listar tabla
        try {
            bienes = bienesService.listarBienes();
            //Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            Utilidades.addMsgError("Error en obtener bienes.", e.getMsgException());
        }
    }

    public Integer getNroPartida() {
        return nroPartida;
    }

    public void setNroPartida(Integer nroPartida) {
        this.nroPartida = nroPartida;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getTipoProp() {
        return tipoProp;
    }

    public void setTipoProp(String tipoProp) {
        this.tipoProp = tipoProp;
    }

    public Map<String, String> getTipoProps() {
        return tipoProps;
    }

    public void setTipoProps(Map<String, String> tipoProps) {
        this.tipoProps = tipoProps;
    }

    public String getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(String tipoBien) {
        this.tipoBien = tipoBien;
    }

    public Map<String, String> getTipoBienes() {
        return tipoBienes;
    }

    public void setTipoBienes(Map<String, String> tipoBienes) {
        this.tipoBienes = tipoBienes;
    }

    public List<Bien> getBienes() {
        return bienes;
    }

    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
    }

    public IFaceBienes getBienesService() {
        return bienesService;
    }

    public void setBienesService(IFaceBienes bienesService) {
        this.bienesService = bienesService;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    // metodos
    public String registrarBien() throws IOException {
        try {
            //setMensaje(getTipoBien() + getTipoProp() + getUbicacion() + getDesc() + String.valueOf(getMontoVal()));
            bienesService.registrarBien(this);
            Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            
            Utilidades.addMsgError("Error en obtener bienes.", e.getMsgException());
            
        }
        return "mantBienes";
    }
    
}
