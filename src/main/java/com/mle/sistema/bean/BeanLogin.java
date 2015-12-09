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
    private String nombreUsuario;
    private int idRol;
    private String rol;
    
    public BeanLogin () {
    }
    
    public IFaceLogin getLoginService() {
        return loginService;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getRol() {
        return idRol;
    }

    public void setRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return rol;
    }

    public void setNombreRol(String rol) {
        this.rol = rol;
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
        
        if (idRol == 1) {
            rol = "Asesor Legal";
            return "inicio_AL"; // asesor legal 
        } 
        else if (idRol == 2) {
            rol = "Abogado";
            return "inicio_A"; // abogado
        }
        else if (idRol == 3) {
            rol = "Procurador Social";
            return "inicio_PS"; // procurador social
        }
        else if (idRol == 4) {
            rol = "Procurador Cobranzas";
            return "inicio_PC"; // procurador de cobranzas
        }
        else if (idRol == 5) {
            rol = "Cliente";
            return "inicio_C"; // cliente
        }
        else return "error";
    }
}
