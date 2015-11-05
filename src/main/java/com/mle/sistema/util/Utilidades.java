/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.util;

import com.mle.sistema.exception.MLEException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oviguan
 */
public class Utilidades {
    /**
     * Función para obtener el objeto FacesContext del contexto de la aplicación
     *
     * @return
     */
    public static FacesContext getFC() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Función para obtener el objeto ExternalContext del contexto de la
     * aplicación
     *
     * @return
     */
    public static ExternalContext getEC() {
        return getFC().getExternalContext();
    }

    /**
     * Función para obtener el objeto HttpServletRequest del contexto de la
     * aplicación
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest)getEC().getRequest();
    }

    /**
     * Función para obtener el objeto HttpServletResponse del contexto de la
     * aplicación
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) getEC().getResponse();
    }

    /**
     * Función para obtener el objeto HttpSession del contexto de la aplicación
     *
     * @return
     */
    public static HttpSession getSession() {
        return (HttpSession)getEC().getSession(false);
    }

    /**
     * Función para agregar mensajes al FacesContext
     *
     * @param titulo
     * @param msg
     */
    public static void addMsg(String titulo, String msg) {
        FacesMessage mensaje = new FacesMessage(titulo, msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    /**
     * Función para agregar mensajes de tipo info al FacesContext
     *
     * @param titulo
     * @param msg
     */
    public static void addMsgInfo(String titulo, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, msg));
    }

    /**
     * Función para agregar mensajes de warn info al FacesContext
     *
     * @param titulo
     * @param msg
     */
    public static void addMsgWarn(String titulo, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, msg));
    }

    /**
     * Función para agregar mensajes de tipo error al FacesContext
     *
     * @param titulo
     * @param msg
     */
    public static void addMsgError(String titulo, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, msg));
    }
    
    public static void cambiarDeArchivoVistaXml(String carpeta, String archivo) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        //context.getExternalContext().redirect("/newfodler/newindex.xhtml");
        context.getExternalContext().redirect("/"+carpeta+"/"+archivo);        
    }
    
    public static void cambiarDeArchivoVistaXml(String archivo) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        //context.getExternalContext().redirect("/newfodler/newindex.xhtml");
        context.getExternalContext().redirect("/"+archivo);        
    }
    
    public static java.util.Date convertir_parametro_Fecha(String parametro_fecha) {
         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = parametro_fecha;
            Date fecha = null;
            try {
            fecha = formatoDelTexto.parse(strFecha);
            } catch (ParseException ex) {
            ex.printStackTrace();
            }
        return fecha;
    }
   
   
    
}
