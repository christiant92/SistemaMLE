/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.dao;

import com.mle.sistema.bean.BeanConsultaBienes;
import com.mle.sistema.entities.Bien;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioConsultaBienes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
public class DAOConsultaBienes implements NegocioConsultaBienes {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void consultarBien(BeanConsultaBienes bean) throws MLEException {
        try {
            Query query = em.createNamedQuery("Bien.findByNroPartida");//Aqui va el nombre del nuevo query que generaste.
                  
            query.setParameter("nroPartida", bean.getNroPartidaBuscar());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor
            //query.setParameter("password", bean.getPassword());//Aqui va el nombre del segundo parametro que pusiste en tu query le anteceden : y su valor
            List<Bien> lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.
            
            if(lista.size() > 0) {
                bean.setNroPartida(lista.get(1).getNroPartida());
                bean.setDesc(lista.get(1).getDescripcion());
                bean.setMontoVal(lista.get(1).getMontoValorizado());
                bean.setTipoBien(lista.get(1).getTipoBien());
                bean.setTipoProp(lista.get(1).getTipoPropietario());
                bean.setUbicacion(lista.get(1).getUbicacion());
                bean.setMensaje("Bien encontrado.");
            }
        } catch (Exception e) {
            throw new MLEException("Error al buscar bien: "+e.getMessage(), e);
        }
        
    }
    
}
