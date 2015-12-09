/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.dao;

import com.mle.sistema.bean.BeanBienes;
import com.mle.sistema.entities.Bien;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioBienes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Christian
 */
public class DAOBienes implements NegocioBienes {
    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceSistemaMLE");
    @PersistenceContext
    private EntityManager em;// = emf.createEntityManager();//Con esta línea instanciamos el administrador de los 
                             //entities para poder ejecutar queries y transacciones a base de datos.
    
    @Override
    public List<Bien> listarBienes() throws MLEException {
        try {
            Query query = em.createNamedQuery("Bien.findAll");//Aqui va el nombre del nuevo query que generaste.
                  
            //query.setParameter("username", bean.getUser());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor
            //query.setParameter("password", bean.getPassword());//Aqui va el nombre del segundo parametro que pusiste en tu query le anteceden : y su valor
            List<Bien> lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.
            
            if(lista.size() > 0) {
                //mensaje = "Lista con datos";
                return lista;
                //bean.setMensaje("El usuario fue encontrado.");
            }
        } catch (Exception e) {
            throw new MLEException("Error en validarUsuario: "+e.getMessage(), e);
        }
        return null;
    }

    @Override
    @Transactional
    public void registrarBien(BeanBienes beanBienes) throws MLEException {
        //Query query = em.createNamedQuery("Bien.insertarBien");//Aqui va el nombre del nuevo query que generaste.
          //  query.executeUpdate();
        //em.getTransaction().begin();
        Bien bienGuardar = new Bien();
        bienGuardar.setNroPartida(beanBienes.getNroPartida());
        bienGuardar.setDescripcion(beanBienes.getDesc());
        bienGuardar.setMontoValorizado(beanBienes.getMontoVal());
        bienGuardar.setTipoBien(beanBienes.getTipoBien());
        bienGuardar.setTipoPropietario(beanBienes.getTipoProp());
        bienGuardar.setUbicacion(beanBienes.getUbicacion());
        bienGuardar.setIdDocumento(null);
        
        em.persist(bienGuardar);
        em.flush();
        
        //em.getTransaction().commit();
    }
    
    
    
    
}
