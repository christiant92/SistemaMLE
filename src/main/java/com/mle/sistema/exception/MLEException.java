/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.exception;

/**
 *
 * @author christian
 */
public class MLEException extends Exception {
    private static final long serialVersionUID = -1837186053658047253L;
    private final String msgError;
    private final Exception exception;
    
    /**
     * Constructor en donde se guardan las excepciones en variables locales
     * @param error
     * @param ex 
     */
    public MLEException(String error, Exception ex) {
        super(error, ex);
        msgError = error;
        exception = ex;
    }
    
    /**
     * Función que regresa la excepción ocurrida en una cadena
     * @return 
     */
    public String getMsgException() {
        return msgError;
    }
    
    /**
     * Función que regresa la excepción ocurrida en un objeto de tipo Exception
     * @return 
     */
    public Exception getException() {
        return exception;
    }
}
