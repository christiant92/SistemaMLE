/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.dao;


import com.mle.sistema.entities.Clientejuridico;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.entities.Pagare;
import com.mle.sistema.entities.Procesojudicial;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioProcesoJudicial;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author FredyRamos
 */

public class DAOProcesoJudicial implements NegocioProcesoJudicial{
    
    //Persistence.createEntityManagerFactory ("persistenceSistemaMLE");
    
    @PersistenceContext
    private EntityManager em;
    FacesContext context = FacesContext.getCurrentInstance();
         
     
    @Override
    public List<Pagare> obtenerListaPagare () throws MLEException {
        try{
        
        List<Pagare> lista = em.createQuery("SELECT c FROM Pagare c").getResultList();
          if(lista.size()>0) {                
                return lista;
            }
        }catch(Exception ex) {
            throw new MLEException("Error en obtenerListaPagare: "+ex.getMessage(), ex);
        }
        return null;
    }
    
    @Override
    public List<Deudor> obtenerListaDeudores () throws MLEException {
        try{
        
        List<Deudor> lista = em.createQuery("SELECT c FROM Deudor c").getResultList();
          if(lista.size()>0) {                
                return lista;
            }
        }catch(Exception ex) {
            throw new MLEException("Error en obtenerListaPagare: "+ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    public void registrarProcesoJudicial(Procesojudicial pj) throws MLEException {
        
    }

    @Override
    public List<Clientejuridico> obtenerListaClientesJuridicos() throws MLEException {
        try{
        List<Clientejuridico> lista = em.createQuery("SELECT c FROM Clientejuridico c").getResultList();
          if(lista.size()>0) {                
                return lista;
            }
        }catch(Exception ex) {
            throw new MLEException("Error en obtenerListaPagare: "+ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    @Transactional
    public void registrarPagare(Pagare p) throws MLEException {
        try{
        em.persist(p);
        em.flush();
        context.addMessage(null, new FacesMessage("Successful",  "Your message: "+p) );
        }catch(Exception ex) {
            throw new MLEException("Error en obtenerListaPagare: "+ex.getMessage(), ex);
        }
    }
}
    
    

