/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.dao;

import com.mle.sistema.bean.BeanConsultarSeguimientoPrestamo;
import com.mle.sistema.bean.BeanRegistrarSeguimientoPrestamo;
import com.mle.sistema.entities.Bien;
import com.mle.sistema.entities.Cliente;
import com.mle.sistema.entities.Clientenatural;
import com.mle.sistema.entities.Cuota;
import com.mle.sistema.entities.CuotaPK;
import com.mle.sistema.entities.Deudor;
import com.mle.sistema.entities.Documento;
import com.mle.sistema.entities.ServPrestamo;
import com.mle.sistema.exception.MLEException;
import com.mle.sistema.negocio.NegocioSeguimientoPrestamo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Oviguan
 */
public class DAOSeguimientoPrestamo implements NegocioSeguimientoPrestamo {

    @PersistenceContext
    private EntityManager em;//Con esta línea instanciamos el administrador de los 
    //entities para poder ejecutar queries y transacciones a base de datos.

    private Clientenatural clientenatural;
    private Cliente cliente;
    private Deudor deudor;
    private Deudor aval;
    private ServPrestamo servPrestamo;

    @Override
    public void validarPrestatario(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        beanSeguimientoPrestamo.setMensajePrestatario("Buscar Deudor");
        try {
            Query query = em.createNamedQuery("Deudor.findByDni");//Aqui va el nombre del nuevo query que generaste.

            query.setParameter("dni", beanSeguimientoPrestamo.getDNI_prestatario());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor
            //query.setParameter("dni", 123);//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor

            List lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.

            if (lista.size() > 0) {

                deudor = (Deudor) lista.get(lista.size() - 1);
                beanSeguimientoPrestamo.setMensajePrestatario("Buscar Deudor: Fue encontrado :" + deudor.getApellidos());
                beanSeguimientoPrestamo.setApellidos_prestatario(deudor.getApellidos());
                beanSeguimientoPrestamo.setNombres_prestatario(deudor.getNombres());
                beanSeguimientoPrestamo.setTeléfono_prestatario(deudor.getTelefono() + "");

            } else {
                beanSeguimientoPrestamo.setMensajePrestatario("Buscar Deudor: No existe");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            beanSeguimientoPrestamo.setMensajePrestatario("Error en DAO validarPrestatario: " + ex.getMessage()
            );
        }

    }

    @Override
    public void validarPrestamista(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        beanSeguimientoPrestamo.setMensajePrestamista("Buscar cliente");
        Query q2 = em.createNativeQuery("SELECT * FROM cliente c,`clientenatural` cn WHERE c.idcliente=cn.Cliente_idCliente AND cn.DNI=" + beanSeguimientoPrestamo.getDNI_prestamista());
        List<Object> result2 = (List<Object>) q2.getResultList();
        System.out.println("lista cliente-clientenatural:" + result2.size());
        Iterator itr2 = result2.iterator();
        while (itr2.hasNext()) {
            Object[] obj = (Object[]) itr2.next();
            System.out.println("0:" + obj[0]);
            System.out.println("1:" + obj[1]);
            System.out.println("2:" + obj[2]);
            System.out.println("3:" + obj[3]);
            System.out.println("4:" + obj[4]);
            System.out.println("5:" + obj[5]);

            cliente = new Cliente();
            cliente.setIdCliente((Integer) obj[0]);
            cliente.setDireccion((String) obj[1]);
            cliente.setDistrito((String) obj[2]);
            cliente.setProvincia((String) obj[3]);
            cliente.setTelefono((int) obj[4]);
            cliente.setEmail((String) obj[5]);

            clientenatural = new Clientenatural();
            clientenatural.setClienteidCliente((Integer) obj[6]);
            clientenatural.setDni((int) obj[7]);
            clientenatural.setNombres((String) obj[8]);
            clientenatural.setApellidos((String) obj[9]);
            clientenatural.setCelular((Integer) obj[10]);
            clientenatural.setCuentaDeposito((String) obj[11]);
            clientenatural.setCliente(cliente);
        }

        if (result2.size() > 0) {
            beanSeguimientoPrestamo.setMensajePrestamista("Buscar cliente: Fue encontrado:" + clientenatural.getApellidos());
            beanSeguimientoPrestamo.setApellidos_prestatario(clientenatural.getApellidos());
            beanSeguimientoPrestamo.setNombres_prestatario(clientenatural.getNombres());
            beanSeguimientoPrestamo.setTeléfono_prestatario(clientenatural.getCelular() + "");

        } else {
            beanSeguimientoPrestamo.setMensajePrestamista("Buscar cliente: No existe");
        }
    }

    @Override
    public void validarAval(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        beanSeguimientoPrestamo.setMensajePrestatario("Buscar Aval");
        Query query = em.createNamedQuery("Deudor.findByDni");//Aqui va el nombre del nuevo query que generaste.

        query.setParameter("dni", beanSeguimientoPrestamo.getDNI_Aval());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor
        //query.setParameter("dni", 123);//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor

        List lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.

        if (lista.size() > 0) {

            aval = (Deudor) lista.get(lista.size() - 1);
            beanSeguimientoPrestamo.setMensajePrestatario("Buscar Aval: Fue encontrado :" + aval.getApellidos());
            beanSeguimientoPrestamo.setApellidosNombres_Aval(aval.getApellidos() + "-"
                    + aval.getNombres());

        } else {
            beanSeguimientoPrestamo.setMensajePrestatario("Buscar Aval: No existe");
        }

    }

    @Override
    @Transactional
    //@Transactional(noRollbackFor = Exception.class)
    //@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void registrarSeguimientoPrestamo(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        try {
            Integer idServPrestamo = 2;
            float montoTotal = Float.parseFloat(beanSeguimientoPrestamo.getMontoPrestamo());
            int numCuotas = Integer.parseInt(beanSeguimientoPrestamo.getNroCuotas());
            Date fecharegistro = beanSeguimientoPrestamo.getFechaInicialPago();
            float montocuota = Integer.parseInt(beanSeguimientoPrestamo.getMontoCuota());;
            String formaCobranza = beanSeguimientoPrestamo.getFormaCobranza();
            float tasaInteres = Float.parseFloat(beanSeguimientoPrestamo.getTasaInteres());;
            Character tipoMoneda = beanSeguimientoPrestamo.getTipoMoneda().toCharArray()[0];
            String tipoMora = "tipo";
            float montomora = 11;
            String estado = "1";
            Deudor deudoridAval = em.find(Deudor.class, 12345678);
            Deudor deudoridDeudor = em.find(Deudor.class, 87654321);
            Cliente cliente = null;
            Clientenatural c = null;
//            Query q = em.createNativeQuery("Select * From cliente c where c.idcliente=1");
//            // Query q =em.createNativeQuery("Select * From clientejuridico c where c.Cliente_idCliente=1");
//            List<Object> result = (List<Object>) q.getResultList();
//            System.out.println("lista cliente:" + result.size());
//            Iterator itr = result.iterator();
//            while (itr.hasNext()) {
//                Object[] obj = (Object[]) itr.next();
//                System.out.println("0:" + obj[0]);
//                System.out.println("1:" + obj[1]);
//                System.out.println("2:" + obj[2]);
//                System.out.println("3:" + obj[3]);
//                System.out.println("4:" + obj[4]);
//                System.out.println("5:" + obj[5]);
//                cliente = new Cliente();
//                cliente.setIdCliente((Integer) obj[0]);
//                cliente.setDireccion((String) obj[1]);
//                cliente.setDistrito((String) obj[2]);
//                cliente.setProvincia((String) obj[3]);
//                cliente.setTelefono((int) obj[4]);
//                cliente.setEmail((String) obj[5]);
//            }
//            Query q1 = em.createNativeQuery("Select * From clientenatural c where c.Cliente_idCliente=1");
//            List<Object> result1 = (List<Object>) q1.getResultList();
//            System.out.println("lista clientenatural:" + result1.size());
//            Iterator itr1 = result1.iterator();
//            while (itr1.hasNext()) {
//                Object[] obj = (Object[]) itr1.next();
//                System.out.println("0:" + obj[0]);
//                System.out.println("1:" + obj[1]);
//                System.out.println("2:" + obj[2]);
//                System.out.println("3:" + obj[3]);
//                System.out.println("4:" + obj[4]);
//                System.out.println("5:" + obj[5]);
//                
//            }

            /**
             * *********************************
             */
            Query q2 = em.createNativeQuery("SELECT * FROM cliente c,`clientenatural` cn WHERE c.idcliente=cn.Cliente_idCliente AND cn.`Cliente_idCliente`=1");
            List<Object> result2 = (List<Object>) q2.getResultList();
            System.out.println("lista cliente-clientenatural:" + result2.size());
            Iterator itr2 = result2.iterator();
            while (itr2.hasNext()) {
                Object[] obj = (Object[]) itr2.next();
                System.out.println("0:" + obj[0]);
                System.out.println("1:" + obj[1]);
                System.out.println("2:" + obj[2]);
                System.out.println("3:" + obj[3]);
                System.out.println("4:" + obj[4]);
                System.out.println("5:" + obj[5]);

                cliente = new Cliente();
                cliente.setIdCliente((Integer) obj[0]);
                cliente.setDireccion((String) obj[1]);
                cliente.setDistrito((String) obj[2]);
                cliente.setProvincia((String) obj[3]);
                cliente.setTelefono((int) obj[4]);
                cliente.setEmail((String) obj[5]);

                c = new Clientenatural();
                c.setClienteidCliente((Integer) obj[6]);
                c.setDni((int) obj[7]);
                c.setNombres((String) obj[8]);
                c.setApellidos((String) obj[9]);
                c.setCelular((Integer) obj[10]);
                c.setCuentaDeposito((String) obj[11]);
                c.setCliente(cliente);
            }

            /**
             * *********************************
             */
            servPrestamo = new ServPrestamo(null, montoTotal, numCuotas, fecharegistro, montocuota, formaCobranza, tasaInteres, tipoMoneda, tipoMora, montomora, estado);

//            servPrestamo.setDeudoridAval(deudoridAval);
//            servPrestamo.setDeudoridDeudor(deudoridDeudor);
//            servPrestamo.setClienteNaturalidCliente(c);
            servPrestamo.setDeudoridAval(aval);
            servPrestamo.setDeudoridDeudor(deudor);
            servPrestamo.setClienteNaturalidCliente(clientenatural);

            em.persist(servPrestamo);
            em.flush();

            System.out.println("Guardooooooooooooooooooooooooooooooooooooo el servicio de prestamo");

            /**
             * *************************** GUARDA LAS CUOTAS
             * *************************************
             */
            DateFormat dateFormat = new SimpleDateFormat("dd");
            String consulta = "SELECT * FROM `serv_prestamo` s WHERE s.`ClienteNatural_idCliente`=" + clientenatural.getClienteidCliente() + " AND s.`Deudor_idDeudor`=" + deudor.getDni() + " AND s.`Deudor_idAval`=" + aval.getDni() + " AND s.`Fecha_registro`='" + (fecharegistro.getYear() + 1900) + "-" + (fecharegistro.getMonth() + 1) + "-" + dateFormat.format(fecharegistro) + "'  AND s.`Monto_Total`='" + montoTotal + "' AND s.`Num_Cuotas`=" + numCuotas;
            System.out.println("consulta serv:" + consulta);
            Query q3 = em.createNativeQuery(consulta);
            List<Object> result3 = (List<Object>) q3.getResultList();
            System.out.println("lista servPrestamo-servPrestamo:" + result3.size());
            Iterator itr3 = result3.iterator();
            int buscado_IdServPrestamo = 0;
            while (itr3.hasNext()) {
                Object[] obj = (Object[]) itr3.next();
                System.out.println("0:" + obj[0]);
                buscado_IdServPrestamo = (int) obj[0];
            }

            CuotaPK cpk = null;
            Cuota cuota = null;
            List<Cuota> listCuotas = new ArrayList<>();
            for (int i = 1; i <= numCuotas; i++) {
                cpk = new CuotaPK(i, buscado_IdServPrestamo);
                cuota = new Cuota(cpk);
                cuota.setEstado('1');
                cuota.setFechacuota(fecharegistro);
                Documento documento = em.find(Documento.class, 1);
                cuota.setIdDocumentoTituloValor(documento);
                cuota.setMontosaldado(montocuota);

                listCuotas.add(cuota);
            }

            ServPrestamo sp = em.find(ServPrestamo.class, buscado_IdServPrestamo);
            sp.setCuotaList(listCuotas);
            em.merge(sp);
            em.flush();

            /**
             * ****************************************************************
             */
            Bien b = new Bien();
            b.setDescripcion("des");
            b.setMontoValorizado(Float.parseFloat("100"));
            b.setNroPartida(100);
            b.setTipoBien("tipo1");
            b.setTipoPropietario("prop1");
            b.setUbicacion("ubic1");
            Documento d = em.find(Documento.class, 1);
            b.setIdDocumento(d);
            em.persist(b);
            em.flush();

            beanSeguimientoPrestamo.setMensajePrestatario("Registrar Seguimiento: OK");
        } catch (Exception ex) {
            ex.printStackTrace();
            beanSeguimientoPrestamo.setMensajePrestatario("Error en DAO insert Servicio Prestamo: " + ex.getMessage()
            );
        }

    }

    @Override
    public void buscarSeguimientoPrestamo(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        beanSeguimientoPrestamo.setMensajeServPrestamo("Buscar ServPrestamo");
        Query query = em.createNamedQuery("ServPrestamo.findByIdServPrestamo");//Aqui va el nombre del nuevo query que generaste.

        query.setParameter("idServPrestamo", beanSeguimientoPrestamo.getIdServ_Prestamo());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor

        List lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.

        if (lista.size() > 0) {

            servPrestamo = (ServPrestamo) lista.get(lista.size() - 1);
            beanSeguimientoPrestamo.setMensajeServPrestamo("Buscar ServPrestamo: Fue encontrado :" + servPrestamo.getIdServPrestamo());

        } else {
            beanSeguimientoPrestamo.setMensajeServPrestamo("Buscar ServPrestamo: No existe");
        }
    }

    @Override
    public List<Clientenatural> validarPrestamista1(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        List<Clientenatural> l = null;
        beanSeguimientoPrestamo.setMensajePrestamista("Buscar cliente");
        Query q2 = em.createNativeQuery("SELECT * FROM cliente c,`clientenatural` cn WHERE c.idcliente=cn.Cliente_idCliente AND cn.DNI=" + beanSeguimientoPrestamo.getDNI_prestamista());
        List<Object> result2 = (List<Object>) q2.getResultList();
        System.out.println("lista cliente-clientenatural:" + result2.size());
        Iterator itr2 = result2.iterator();
        while (itr2.hasNext()) {
            Object[] obj = (Object[]) itr2.next();
            System.out.println("0:" + obj[0]);
            System.out.println("1:" + obj[1]);
            System.out.println("2:" + obj[2]);
            System.out.println("3:" + obj[3]);
            System.out.println("4:" + obj[4]);
            System.out.println("5:" + obj[5]);

            cliente = new Cliente();
            cliente.setIdCliente((Integer) obj[0]);
            cliente.setDireccion((String) obj[1]);
            cliente.setDistrito((String) obj[2]);
            cliente.setProvincia((String) obj[3]);
            cliente.setTelefono((int) obj[4]);
            cliente.setEmail((String) obj[5]);

            clientenatural = new Clientenatural();
            clientenatural.setClienteidCliente((Integer) obj[6]);
            clientenatural.setDni((int) obj[7]);
            clientenatural.setNombres((String) obj[8]);
            clientenatural.setApellidos((String) obj[9]);
            clientenatural.setCelular((Integer) obj[10]);
            clientenatural.setCuentaDeposito((String) obj[11]);
            clientenatural.setCliente(cliente);

            l = new ArrayList<Clientenatural>();
            l.add(clientenatural);
        }

        if (result2.size() > 0) {
            beanSeguimientoPrestamo.setMensajePrestamista("Buscar cliente: Fue encontrado:" + clientenatural.getApellidos());
            beanSeguimientoPrestamo.setApellidos_prestatario(clientenatural.getApellidos());
            beanSeguimientoPrestamo.setNombres_prestatario(clientenatural.getNombres());
            beanSeguimientoPrestamo.setTeléfono_prestatario(clientenatural.getCelular() + "");

        } else {
            beanSeguimientoPrestamo.setMensajePrestamista("Buscar cliente: No existe");
            clientenatural = new Clientenatural();
        }

        return l;
    }

    @Override
    public List<Deudor> validarPrestatario1(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        List<Deudor> l = null;
        beanSeguimientoPrestamo.setMensajePrestatario("Buscar Deudor");
        try {
            Query query = em.createNamedQuery("Deudor.findByDni");//Aqui va el nombre del nuevo query que generaste.

            query.setParameter("dni", beanSeguimientoPrestamo.getDNI_prestatario());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor
            //query.setParameter("dni", 123);//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor

            List lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.

            if (lista.size() > 0) {

                deudor = (Deudor) lista.get(lista.size() - 1);
                beanSeguimientoPrestamo.setMensajePrestatario("Buscar Deudor: Fue encontrado :" + deudor.getApellidos());
                beanSeguimientoPrestamo.setApellidos_prestatario(deudor.getApellidos());
                beanSeguimientoPrestamo.setNombres_prestatario(deudor.getNombres());
                beanSeguimientoPrestamo.setTeléfono_prestatario(deudor.getTelefono() + "");

                l = new ArrayList<Deudor>();
                l.add(deudor);
            } else {
                beanSeguimientoPrestamo.setMensajePrestatario("Buscar Deudor: No existe");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            beanSeguimientoPrestamo.setMensajePrestatario("Error en DAO validarPrestatario: " + ex.getMessage()
            );
        }
        return l;
    }

    @Override
    public List<Deudor> validarAval1(BeanRegistrarSeguimientoPrestamo beanSeguimientoPrestamo) throws MLEException {
        List<Deudor> l = null;
        beanSeguimientoPrestamo.setMensajePrestatario("Buscar Aval");
        Query query = em.createNamedQuery("Deudor.findByDni");//Aqui va el nombre del nuevo query que generaste.

        query.setParameter("dni", beanSeguimientoPrestamo.getDNI_Aval());//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor
        //query.setParameter("dni", 123);//Aqui va el nombre del primer parametro que pusiste en tu query le anteceden : y su valor

        List lista = query.getResultList();//Ejecutamos el query y lo guardamos en una lista.

        if (lista.size() > 0) {

            aval = (Deudor) lista.get(lista.size() - 1);
            beanSeguimientoPrestamo.setMensajePrestatario("Buscar Aval: Fue encontrado :" + aval.getApellidos());
            beanSeguimientoPrestamo.setApellidosNombres_Aval(aval.getApellidos() + "-"
                    + aval.getNombres());
            l = new ArrayList<Deudor>();
            l.add(aval);

        } else {
            beanSeguimientoPrestamo.setMensajePrestatario("Buscar Aval: No existe");
        }
        return l;
    }

    @Override
    public List<ServPrestamo> buscarServPrestamos(BeanConsultarSeguimientoPrestamo beanConsultarSeguimientoPrestamo) throws MLEException {
        List<ServPrestamo> l = null;
        List<Cuota> lc = null;
        ServPrestamo sp = null;
        int buscado_idServ_Prestamo = Integer.parseInt(beanConsultarSeguimientoPrestamo.getTxt_idServ_Prestamo());
        try {
            Query q2 = em.createNativeQuery("SELECT * FROM `serv_prestamo` s WHERE s.`idServ_Prestamo`=" + buscado_idServ_Prestamo);
            List<Object> result2 = (List<Object>) q2.getResultList();
            System.out.println("lista serv_prestamo-serv_prestamo:" + result2.size());
            Iterator itr2 = result2.iterator();
            while (itr2.hasNext()) {

                Object[] obj = (Object[]) itr2.next();
                sp = new ServPrestamo((Integer) obj[0]);
                System.out.println("0:" + obj[0]);
                System.out.println("1:" + obj[1]);
                System.out.println("2:" + obj[2]);
                System.out.println("3:" + obj[3]);
                System.out.println("4:" + obj[4]);
                System.out.println("5:" + obj[5]);
                System.out.println("6:" + obj[6]);
                System.out.println("7:" + obj[7]);
                System.out.println("8:" + obj[8]);
                System.out.println("9:" + obj[9]);
                System.out.println("10:" + obj[10]);
                System.out.println("11:" + obj[11]);
                System.out.println("12:" + obj[12]);
                System.out.println("13:" + obj[13]);
                /**
                 * ************************************************************
                 */
                Cliente b_cliente = null;
                Clientenatural b_clientenatural = null;
                Query q3 = em.createNativeQuery("SELECT * FROM cliente c,`clientenatural` cn WHERE c.idcliente=cn.Cliente_idCliente AND cn.Cliente_idCliente=" + obj[1]);
                List<Object> result3 = (List<Object>) q3.getResultList();
                System.out.println("lista cliente-clientenatural:" + result3.size());
                Iterator itr3 = result3.iterator();
                while (itr3.hasNext()) {
                    Object[] obj1 = (Object[]) itr3.next();
                    b_cliente = new Cliente();
                    b_cliente.setIdCliente((Integer) obj1[0]);
                    b_cliente.setDireccion((String) obj1[1]);
                    b_cliente.setDistrito((String) obj1[2]);
                    b_cliente.setProvincia((String) obj1[3]);
                    b_cliente.setTelefono((int) obj1[4]);
                    b_cliente.setEmail((String) obj1[5]);

                    b_clientenatural = new Clientenatural();
                    b_clientenatural.setClienteidCliente((Integer) obj1[6]);
                    b_clientenatural.setDni((int) obj1[7]);
                    b_clientenatural.setNombres((String) obj1[8]);
                    b_clientenatural.setApellidos((String) obj1[9]);
                    b_clientenatural.setCelular((Integer) obj1[10]);
                    b_clientenatural.setCuentaDeposito((String) obj1[11]);
                    b_clientenatural.setCliente(b_cliente);

                }

                sp.setClienteNaturalidCliente(b_clientenatural);
//                sp.setClienteNaturalidCliente((Clientenatural) obj[1]);
                /**
                 * ************************************************************
                 */

                Deudor b_deudor = em.find(Deudor.class, obj[2]);
                sp.setDeudoridDeudor(b_deudor);
//                sp.setDeudoridDeudor((Deudor) obj[2]);

                Deudor b_aval = em.find(Deudor.class, obj[3]);
                sp.setDeudoridAval(b_aval);
//                sp.setDeudoridAval((Deudor) obj[3]);
                sp.setMontoTotal((float) obj[4]);
                sp.setNumCuotas((int) obj[5]);
                sp.setFecharegistro((Date) obj[6]);
                sp.setMontocuota((float) obj[7]);
                sp.setFormaCobranza((String) obj[8]);
                sp.setTasaInteres((float) obj[9]);
                sp.setTipoMoneda((Character) obj[10]);
                sp.setTipoMora((String) obj[11]);
                sp.setMontomora((float) obj[12]);
                sp.setEstado((String) obj[13]);
                
            /*************************** CARGAR CUOTAS ***************************************/
                CuotaPK b_cuotaPK = null;
                Cuota b_cuota = null;
                Query q4 = em.createNativeQuery("SELECT * FROM `cuota` c WHERE c.`idServ_Prestamo`=" + buscado_idServ_Prestamo);
                List<Object> result4 = (List<Object>) q4.getResultList();
                System.out.println("lista cuota-cuota:" + result4.size());
                Iterator itr4 = result4.iterator();
                
                if (result4.size()>0) {
                    lc= new ArrayList<Cuota>();
                }
                while (itr4.hasNext()) {
                    Object[] obj1 = (Object[]) itr4.next();
                    b_cuotaPK = new CuotaPK((Integer) obj1[0], buscado_idServ_Prestamo);                    
                    b_cuota = new Cuota(b_cuotaPK);
                    Documento d1=em.find(Documento.class, obj1[2]);
                    b_cuota.setIdDocumentoTituloValor(d1);
                    b_cuota.setEstado((Character) obj1[3]);
                    b_cuota.setMontosaldado((float) obj1[4]);
                    b_cuota.setFechacuota((Date) obj1[5]);
                    lc.add(b_cuota);
                }
                sp.setCuotaList(lc);
            /******************************************************************/     

            l = new ArrayList<ServPrestamo>();
            l.add(sp);
            }

            if (result2.size() > 0) {
                beanConsultarSeguimientoPrestamo.setMensaje_ServPrestamo("Buscar serv_prestamo: Fue encontrado:");

            } else {
                beanConsultarSeguimientoPrestamo.setMensaje_ServPrestamo("Buscar serv_prestamo: No existe");

            }

        } catch (Exception e) {
            e.printStackTrace();
            beanConsultarSeguimientoPrestamo.setMensaje_ServPrestamo("Error en DAO buscarServPrestamos: " + e.getMessage());
        }

        return l;
    }

}
