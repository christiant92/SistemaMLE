/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.negocio;

import com.mle.sistema.bean.BeanConsultarSeguimientoPrestamo;
import com.mle.sistema.bean.BeanRegistrarSeguimientoPrestamo;
import com.mle.sistema.entities.Clientenatural;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.entities.ServPrestamo;
import com.mle.sistema.exception.MLEException;
import java.util.List;

/**
 *
 * @author Oviguan
 */
public interface NegocioSeguimientoPrestamo {

    public void validarPrestatario(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public void validarPrestamista(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public void validarAval(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public void registrarSeguimientoPrestamo(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public void buscarSeguimientoPrestamo(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public List<Clientenatural> validarPrestamista1(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public List<Deudor> validarPrestatario1(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public List<Deudor> validarAval1(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException;

    public List<ServPrestamo> buscarServPrestamos(BeanConsultarSeguimientoPrestamo beanConsultarSeguimientoPrestamo) throws MLEException;

    
}
