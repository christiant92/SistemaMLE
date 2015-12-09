/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;

import com.mle.sistema.bean.BeanBienes;
import com.mle.sistema.entities.Bien;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioBienes;
import java.util.List;


/**
 *
 * @author Christian
 */
public class ServicioBienes implements IFaceBienes {
    private NegocioBienes daoBienes;

    @Override
    public List<Bien> listarBienes() throws MLEException {
        return getDaoBienes().listarBienes();
    }

    @Override
    public void registrarBien(BeanBienes beanBienes) throws MLEException {
        daoBienes.registrarBien(beanBienes);
    }

    public void setDaoBienes(NegocioBienes daoBienes) {
        this.daoBienes = daoBienes;
    }

    public NegocioBienes getDaoBienes() {
        return daoBienes;
    }
}
