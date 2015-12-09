/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.bean;

/**
 *
 * @author FredyRamos
 */

import com.mle.sistema.entities.Clientejuridico;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.entities.Juzgado;
import com.mle.sistema.entities.Medidacautelar;
import com.mle.sistema.entities.Pagare;
import com.mle.sistema.entities.Procesojudicial;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.servicios.IFaceProcesoJudicial;
import com.mle.sistema.util.Utilidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean(name="ProcesoJudicialBean")
@ViewScoped
public class BeanProcesoJudicial implements Serializable {
    
    
    
    private List<Pagare> listaPagares;
    
    private List<Clientejuridico> listaClienteJuridicos;
    private HashMap mapClientes;
    private Clientejuridico clienteJuridico;
    private String codigoClienteJuridico;
    
    private List<Deudor> listaDeudores;
    private HashMap mapDeudores;
    private Deudor deudor;
    private Deudor deudorAval;
    private String codigoDeudor;
    private String codigoDeudorAval;
    
    private Pagare pagareNuevo;
    
    
    private List<SelectItem> listaNroPagares;
    private String idPagare;
    
    private String mensaje;
    
    private String numPagare;
    private String saldoCapital;
    private String diasMora;
    private String codCredito;
    private String saldoCuota;
    private String codDeudor;
    private Date fechaPrestamo;
    private String SituacionContractual;
    
      
    @ManagedProperty("#{serviceProcesoJudicial}")
    private IFaceProcesoJudicial procesoJudicialService;
     
    @PostConstruct
    public void init() {
        mapDeudores = new HashMap();
        mapClientes = new HashMap();
        pagareNuevo = new Pagare();
        
        //listar tabla
        try {
            listaPagares = procesoJudicialService.obtenerListaPagare();
            Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            Utilidades.addMsgError("Error en obtener bienes.", e.getMsgException());
        }
         try {
            listaDeudores = procesoJudicialService.obtenerListaDeudores();
            Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            Utilidades.addMsgError("Error en obtener bienes.", e.getMsgException());
        }
         
        if (listaDeudores != null) {
            for (int i = 0; i < listaDeudores.size(); i++) {
                Deudor d = listaDeudores.get(i);
                mapDeudores.put(d.getDni().toString(), d);
            }
        }
         
         try {
            listaClienteJuridicos = procesoJudicialService.obtenerListaClientesJuridicos();
            Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            Utilidades.addMsgError("Error en obtener bienes.", e.getMsgException());
        }
         
        if (listaClienteJuridicos != null) {
            for (int i = 0; i < listaClienteJuridicos.size(); i++) {
                Clientejuridico c = listaClienteJuridicos.get(i);
                mapClientes.put(c.getClienteidCliente().toString(), c);
            }
        }
    }
    
    public IFaceProcesoJudicial getProcesoJudicialService() {
        return procesoJudicialService;
    }

    public void setProcesoJudicialService(IFaceProcesoJudicial procesoJudicialService) {
        this.procesoJudicialService = procesoJudicialService;
    }

    

    public List<Pagare> getListaPagares() {
        return listaPagares;
    }

    public void setListaPagares(List<Pagare> listaPagares) {
        this.listaPagares = listaPagares;
    }

    public List<SelectItem> getListaNroPagares() {
        return listaNroPagares;
    }

    public void setListaNroPagares(List<SelectItem> listaNroPagares) {
        this.listaNroPagares = listaNroPagares;
    }

    public String getIdPagare() {
        return idPagare;
    }

    public void setIdPagare(String idPagare) {
        this.idPagare = idPagare;
    }
    
  
    public List<Deudor> getListaDeudores() {
        return listaDeudores;
    }

    public void setListaDeudores(List<Deudor> listaDeudores) {
        this.listaDeudores = listaDeudores;
    }

    public Deudor getDeudor() {
        return deudor;
    }

    public void setDeudor(Deudor deudor) {
        this.deudor = deudor;
    }

    public List<Clientejuridico> getListaClienteJuridicos() {
        return listaClienteJuridicos;
    }

    public void setListaClienteJuridicos(List<Clientejuridico> listaClienteJuridicos) {
        this.listaClienteJuridicos = listaClienteJuridicos;
    }

    public Clientejuridico getClienteJuridico() {
        return clienteJuridico;
    }

    public void setClienteJuridico(Clientejuridico clienteJuridico) {
        this.clienteJuridico = clienteJuridico;
    }

    public String getCodigoClienteJuridico() {
        return codigoClienteJuridico;
    }

    public void setCodigoClienteJuridico(String codigoClienteJuridico) {
        this.codigoClienteJuridico = codigoClienteJuridico;
    }
    
//
    
    public void escogerClienteJuridico(){
        if(codigoClienteJuridico==null||codigoClienteJuridico.equals("")){
        this.clienteJuridico = null;
        }else{
        this.clienteJuridico=(Clientejuridico)getMapClientes().get(this.codigoClienteJuridico);
        }
   }
    
    public void escogerDeudor(){
        if(codigoDeudor==null||codigoDeudor.equals("")){
        this.deudor = null;
        }else{
        this.deudor=(Deudor)getMapDeudores().get(this.codigoDeudor);
        }
   }
    
      public void escogerDeudorAval(){
        if(codigoDeudorAval==null||codigoDeudorAval.equals("")){
        this.deudorAval = null;
        }else{
        this.deudorAval=(Deudor)getMapDeudores().get(this.codigoDeudorAval);
        }
   }

      //
    public HashMap getMapClientes() {
        return mapClientes;
    }

    public void setMapClientes(HashMap mapClientes) {
        this.mapClientes = mapClientes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap getMapDeudores() {
        return mapDeudores;
    }

    public void setMapDeudores(HashMap mapDeudores) {
        this.mapDeudores = mapDeudores;
    }

    public Deudor getDeudorAval() {
        return deudorAval;
    }

    public void setDeudorAval(Deudor deudorAval) {
        this.deudorAval = deudorAval;
    }

    public String getCodigoDeudor() {
        return codigoDeudor;
    }

    public void setCodigoDeudor(String codigoDeudor) {
        this.codigoDeudor = codigoDeudor;
    }

    public String getCodigoDeudorAval() {
        return codigoDeudorAval;
    }

    public void setCodigoDeudorAval(String codigoDeudorAval) {
        this.codigoDeudorAval = codigoDeudorAval;
    }

    public Pagare getPagareNuevo() {
        return pagareNuevo;
    }

    public void setPagareNuevo(Pagare pagareNuevo) {
        this.pagareNuevo = pagareNuevo;
    }

    public String getSaldoCapital() {
        return saldoCapital;
    }

    public void setSaldoCapital(String saldoCapital) {
        this.saldoCapital = saldoCapital;
    }

    public String getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(String diasMora) {
        this.diasMora = diasMora;
    }

    public String getCodCredito() {
        return codCredito;
    }

    public void setCodCredito(String codCredito) {
        this.codCredito = codCredito;
    }

    public String getSaldoCuota() {
        return saldoCuota;
    }

    public void setSaldoCuota(String saldoCuota) {
        this.saldoCuota = saldoCuota;
    }

    public String getCodDeudor() {
        return codDeudor;
    }

    public void setCodDeudor(String codDeudor) {
        this.codDeudor = codDeudor;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getSituacionContractual() {
        return SituacionContractual;
    }

    public void setSituacionContractual(String SituacionContractual) {
        this.SituacionContractual = SituacionContractual;
    }

    public String getNumPagare() {
        return numPagare;
    }

    public void setNumPagare(String numPagare) {
        this.numPagare = numPagare;
    }
    
    
     public void registrarPagare(){
        try {
            pagareNuevo.setClienteidCliente(clienteJuridico);
            pagareNuevo.setCodCredito(codCredito);
            pagareNuevo.setCodDeudor(codDeudor);
            pagareNuevo.setDeudoridAval(deudorAval);
            pagareNuevo.setDeudoridDeudor(deudor);
            pagareNuevo.setDiasMora(Integer.parseInt(diasMora));
            pagareNuevo.setFechaPrestamo(fechaPrestamo);
            pagareNuevo.setNumPagare(Integer.parseInt(numPagare));
            pagareNuevo.setSaldoCapital(Float.parseFloat(saldoCapital));
            pagareNuevo.setSaldoCuota(Float.parseFloat(saldoCuota));
            pagareNuevo.setSituacionContractual(SituacionContractual);
            
            this.procesoJudicialService.registrarPagare( pagareNuevo );
            Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            Utilidades.addMsgError("Error en validar usuario.", e.getMsgException());
        }
    }
    
}
