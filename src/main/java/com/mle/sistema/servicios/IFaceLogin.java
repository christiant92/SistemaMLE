/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;

import com.mle.sistema.bean.BeanLogin;
import com.mle.sistema.exception.MLEException;

/**
 *
 * @author christian
 */
public interface IFaceLogin {
    public void validarUsuario(BeanLogin bean) throws MLEException;
}
