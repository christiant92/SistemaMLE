/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.dao;

import com.mle.sistema.bean.BeanLogin;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioLogin;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author christian
 */
public class DAOLogin implements NegocioLogin {
    @PersistenceContext
    private EntityManager em;//Con esta línea instanciamos el administrador de los 
                             //entities para poder ejecutar queries y transacciones a base de datos.

    @Override
    public void validarUsuario(BeanLogin bean) throws MLEException {
        //boolean estado=false;
        try {
            Query query = em.createNamedQuery("Usuario.findByUserNameAndPassword");//Aqui va el nombre del nuevo query que generaste.
                  
            query.setParameter("userName", bean.getUser());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor
            query.setParameter("password", bean.getPassword());//Aqui va el nombre del segundo parametro que pusiste en tu query le anteceden : y su valor
            List lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.
            
            if(lista.size() > 0) {                
                bean.setMensaje("Usuario encontrado.");
                
            } else {
                bean.setMensaje("El usuario no fue encontrado.");
            }
            
            System.out.println("Username: "+bean.getUser());
            System.out.println("Password: "+bean.getPassword());
        } catch(Exception ex) {
            throw new MLEException("Error en validarUsuario: "+ex.getMessage(), ex);
        }
    }
}
