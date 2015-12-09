/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.negocio;



import com.mle.sistema.entities.Clientejuridico;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.entities.Pagare;
import com.mle.sistema.entities.Procesojudicial;
import com.mle.sistema.exception.MLEException;
import java.util.List;

/**
 *
 * @author christian
 */
public interface NegocioProcesoJudicial {
    public void registrarProcesoJudicial(Procesojudicial pj) throws MLEException;
    public List<Pagare> obtenerListaPagare() throws MLEException;
    public List<Deudor> obtenerListaDeudores () throws MLEException;
    public List<Clientejuridico> obtenerListaClientesJuridicos() throws MLEException;
    public void registrarPagare(Pagare p) throws MLEException;
}
