/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;

import com.mle.sistema.bean.BeanConsultaBienes;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioConsultaBienes;

/**
 *
 * @author Christian
 */
public class ServicioConsultaBienes implements IFaceConsultaBienes {
    private NegocioConsultaBienes daoConsultaBienes;
    
    @Override
    public void consultarBien(BeanConsultaBienes bean) throws MLEException  {
        daoConsultaBienes.consultarBien(bean);
    }

    public NegocioConsultaBienes getDaoConsultaBienes() {
        return daoConsultaBienes;
    }

    public void setDaoConsultaBienes(NegocioConsultaBienes daoConsultaBienes) {
        this.daoConsultaBienes = daoConsultaBienes;
    }

    
    
}
