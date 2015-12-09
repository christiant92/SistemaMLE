/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;

import com.mle.sistema.bean.BeanBienes;
import com.mle.sistema.entities.Bien;
import com.mle.sistema.exception.MLEException;
import java.util.List;

/**
 *
 * @author Christian
 */
public interface IFaceBienes {
    public List<Bien> listarBienes() throws MLEException;
    
    public void registrarBien(BeanBienes beanBienes) throws MLEException;
}
