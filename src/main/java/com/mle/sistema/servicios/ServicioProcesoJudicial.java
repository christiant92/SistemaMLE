/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.servicios;


import com.mle.sistema.entities.Clientejuridico;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.entities.Pagare;
import com.mle.sistema.entities.Procesojudicial;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioProcesoJudicial;
import java.util.List;


/**
 *
 * @author FredyRamos
 */

public class ServicioProcesoJudicial implements IFaceProcesoJudicial {
     
    private NegocioProcesoJudicial daoProcesoJudicial;
    
   
    
    /**
     * @return the daoLogin
     */
    
    public NegocioProcesoJudicial getDaoProcesoJudicial() {
        return daoProcesoJudicial;
    }

    /**
     * @param daoLogin the daoLogin to set
     */
   
    public void setDaoProcesoJudicial(NegocioProcesoJudicial daoProcesoJudicial) {
        this.daoProcesoJudicial = daoProcesoJudicial;
    }

   
    @Override
    public List<Pagare> obtenerListaPagare() throws MLEException {
        return getDaoProcesoJudicial().obtenerListaPagare();
    }

    @Override
    public void registrarProcesoJudicial(Procesojudicial pj) throws MLEException {
         
    }
    public List<Deudor> obtenerListaDeudores () throws MLEException
    {
        return getDaoProcesoJudicial().obtenerListaDeudores();
    }
    
    public List<Clientejuridico> obtenerListaClientesJuridicos() throws MLEException
    {
        return getDaoProcesoJudicial().obtenerListaClientesJuridicos();
    }

    @Override
    public void registrarPagare(Pagare p) throws MLEException {
        
        getDaoProcesoJudicial().registrarPagare(p);
    }
}


   

   

