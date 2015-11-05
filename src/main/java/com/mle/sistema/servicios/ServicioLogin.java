/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;

import com.mle.sistema.bean.BeanLogin;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioLogin;

/**
 *
 * @author christian
 */
public class ServicioLogin implements IFaceLogin {
    private NegocioLogin daoLogin;
    
    @Override
    public void validarUsuario(BeanLogin bean) throws MLEException {
        getDaoLogin().validarUsuario(bean);
    }

    /**
     * @return the daoLogin
     */
    public NegocioLogin getDaoLogin() {
        return daoLogin;
    }

    /**
     * @param daoLogin the daoLogin to set
     */
    public void setDaoLogin(NegocioLogin daoLogin) {
        this.daoLogin = daoLogin;
    }
}
