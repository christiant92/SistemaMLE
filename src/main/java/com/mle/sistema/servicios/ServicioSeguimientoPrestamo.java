/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;

import com.mle.sistema.bean.BeanConsultarSeguimientoPrestamo;
import com.mle.sistema.bean.BeanRegistrarSeguimientoPrestamo;
import com.mle.sistema.entities.Clientenatural;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.entities.ServPrestamo;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioSeguimientoPrestamo;
import java.util.List;

/**
 *
 * @author Oviguan
 */
public class ServicioSeguimientoPrestamo implements IFaceSeguimientoPrestamo{
    private NegocioSeguimientoPrestamo daoSeguimientoPrestamo;

    public NegocioSeguimientoPrestamo getDaoSeguimientoPrestamo() {
        return daoSeguimientoPrestamo;
    }

    public void setDaoSeguimientoPrestamo(NegocioSeguimientoPrestamo daoSeguimientoPrestamo) {
        this.daoSeguimientoPrestamo = daoSeguimientoPrestamo;
    }
    
    
    
    
    @Override
    public void validarPrestamista(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
        getDaoSeguimientoPrestamo().validarPrestamista(bean);
    }
    
    @Override
    public void validarPrestatario(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
       getDaoSeguimientoPrestamo().validarPrestatario(bean);        
    }

    @Override
    public void validarAval(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
        getDaoSeguimientoPrestamo().validarAval(bean);
    }

    @Override
    public void registrarSeguimientoPrestamo(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
        getDaoSeguimientoPrestamo().registrarSeguimientoPrestamo(bean);
    }
    
    @Override
    public void buscarSeguimientoPrestamo(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
        getDaoSeguimientoPrestamo().registrarSeguimientoPrestamo(bean);
    }

    @Override
    public List<Clientenatural> validarPrestamista1(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
        return getDaoSeguimientoPrestamo().validarPrestamista1(bean);
    }
    
    @Override
    public List<Deudor> validarPrestatario1(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
        return getDaoSeguimientoPrestamo().validarPrestatario1(bean);
    }
    
    @Override
    public List<Deudor> validarAval1(BeanRegistrarSeguimientoPrestamo bean) throws MLEException {
        return getDaoSeguimientoPrestamo().validarAval1(bean);
    }

    @Override
    public List<ServPrestamo> buscarServPrestamos(BeanConsultarSeguimientoPrestamo beanConsultarSeguimientoPrestamo) throws MLEException {
       return getDaoSeguimientoPrestamo().buscarServPrestamos(beanConsultarSeguimientoPrestamo);
    }
    
  
}
