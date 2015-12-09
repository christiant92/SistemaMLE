/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;

import com.mle.sistema.bean.BeanConsultaBienes;
import com.mle.sistema.exception.MLEException;

/**
 *
 * @author Christian
 */
public interface IFaceConsultaBienes {
    public void consultarBien(BeanConsultaBienes bean) throws MLEException ;
}
