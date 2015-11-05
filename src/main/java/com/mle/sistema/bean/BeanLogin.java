/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.bean;

import com.mle.sistema.exception.MLEException;
import com.mle.sistema.servicios.IFaceLogin;
import com.mle.sistema.util.Utilidades;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author christian
 */
//@ManagedBean(name = "loginBean")
//@ViewScoped
public class BeanLogin implements Serializable {
    private IFaceLogin loginService;
    private String user;
    private String password;
    private String mensaje;
    
    public BeanLogin () {}
    
    public IFaceLogin getLoginService() {
        return loginService;
    }

    public void setLoginService(IFaceLogin loginService) {
        this.loginService = loginService;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String validarLogin() throws IOException {
        /*context-path: /SistemaMLE-1.0-SNAPSHOT*/
        try {
            loginService.validarUsuario(this);
            Utilidades.addMsgInfo("Mensaje", getMensaje());
        } catch (MLEException e) {
            Utilidades.addMsgError("Error en validar usuario.", e.getMsgException());
        }
        
        return "regProcesoJudicial.xhtml";
    }
}
