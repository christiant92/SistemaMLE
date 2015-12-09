/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mle.sistema.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CarlosWMx
 */
@ManagedBean
@ViewScoped
public class BeanDeudorNatural implements Serializable {

    private BigInteger dni;
    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String provincia;
    private String distrito;
    private Map<String, String> provincias;
    private Map<String, String> distritos;

    @PostConstruct
    public void init() {
        provincias = new HashMap<String, String>();
        provincias.put("Barranca", "Barranca");
        provincias.put("Cajatambo", "Cajatambo");
        provincias.put("Canta", "Canta");
        provincias.put("Cañete", "Cañete");
        provincias.put("Huaral", "Huaral");
        provincias.put("Huarochirí", "Huarochirí");
        provincias.put("Huaura", "Huaura");
        provincias.put("Lima", "Lima");
        provincias.put("Oyon", "Oyon");
        provincias.put("Yauyos", "Yauyos");

        Map<String, String> map = new HashMap<String, String>();
        map.put("Barranca", "Barranca");
        map.put("Paramonga", "Paramonga");
        map.put("Pativilca", "Pativilca");
        map.put("Supe", "Supe");
        map.put("Supe Puerto", "Supe Puerto");
        data.put("Barranca", map);

        map = new HashMap<String, String>();
        map.put("Manás", "Manás");
        map.put("Gorgor", "Gorgor");
        map.put("Huancapón", "Huancapón");
        map.put("Cajatambo", "Cajatambo");
        map.put("Copa", "Copa");
        data.put("Cajatambo", map);

        map = new HashMap<String, String>();
        map.put("Canta", "Canta");
        map.put("Arahuay", "Arahuay");
        map.put("Huamantanga", "Huamantanga");
        map.put("Huaros", "Huaros");
        map.put("Lachaqui", "Lachaqui");
        map.put("San Buenaventura", "San Buenaventura");
        map.put("Santa Rosa de Quives", "Santa Rosa de Quives");
        data.put("Canta", map);

        map = new HashMap<String, String>();
        map.put("Asia", "Asia");
        map.put("Calango", "Calango");
        map.put("Cerro Azul", "Cerro Azul");
        map.put("Chilca", "Chilca");
        map.put("Coayllo", "Coayllo");
        map.put("Imperial", "Imperial");
        map.put("Lunahuana", "Lunahuana");
        map.put("Mala", "Mala");
        map.put("Nuevo Imperial", "Nuevo Imperial");
        map.put("Pacaran", "Pacaran");
        map.put("Quilmana", "Quilmana");
        map.put("San Antonio", "San Antonio");
        map.put("San Luis", "San Luis");
        map.put("San Vicente Cañete", "San Vicente Cañete");
        map.put("Santa Cruz de Flores", "Santa Cruz de Flores");
        map.put("Zuñiga", "Zuñiga");
        data.put("Cañete", map);

        map = new HashMap<String, String>();
        map.put("27 de Noviembre", "27 de Noviembre");
        map.put("Atavillos Alto", "Atavillos Alto");
        map.put("Atavillos Bajo", "Atavillos Bajo");
        map.put("Aucallama", "Aucallama");
        map.put("Chancay", "Chancay");
        map.put("Huaral", "Huaral");
        map.put("Ihuarí", "Ihuarí");
        map.put("Lampían", "Lampían");
        map.put("Pacaraos", "Pacaraos");
        map.put("Santa Cruz de Andamarca", "Santa Cruz de Andamarca");
        map.put("Sumbilca", "Sumbilca");
        map.put("San Miguel de Acos", "San Miguel de Acos");
        data.put("Huaral", map);

        map = new HashMap<String, String>();
        map.put("Matucana", "Matucana");
        map.put("Antioquía", "Antioquía");
        map.put("Callahuanca", "Callahuanca");
        map.put("Carampoma", "Carampoma");
        map.put("Chilca", "Chilca");
        map.put("Cuenca", "Cuenca");
        map.put("Huachupampa", "Huachupampa");
        map.put("Huanza", "Huanza");
        map.put("Huarochirí", "Huarochirí");
        map.put("Lahuaytambo", "Lahuaytambo");
        map.put("Langa", "Langa");
        map.put("Laraos", "Laraos");
        map.put("Mariatana", "Mariatana");
        map.put("Ricardo Palma", "Ricardo Palma");
        map.put("San Andrés de Tupicocha", "San Andrés de Tupicocha");
        map.put("San Antonio de Chaclla", "San Antonio de Chaclla");
        map.put("San Bartolomé", "San Bartolomé");
        map.put("San Damián", "San Damián");
        map.put("San Juan de Iris", "San Juan de Iris");
        map.put("San Juan de Tantaranche", "San Juan de Tantaranche");
        map.put("San Lorenzo de Quinti", "San Lorenzo de Quinti");
        map.put("San Mateo", "San Mateo");
        map.put("San Mateo de Otao", "San Mateo de Otao");
        map.put("San Pedro de Casta", "San Pedro de Casta");
        map.put("San Pedro de Huancayre", "San Pedro de Huancayre");
        map.put("Sangallaya", "Sangallaya");
        map.put("Santa Cruz de Cocachacra", "Santa Cruz de Cocachacra");
        map.put("Santa Eulalia", "Santa Eulalia");
        map.put("Santantiago de Anchucaya", "Santantiago de Anchucaya");
        map.put("Santiago de Tuna", "Santiago de Tuna");
        map.put("Santo Domingo de los Olleros", "Santo Domingo de los Olleros");
        map.put("San Jerónimo de Surco", "San Jerónimo de Surco");
        data.put("Huarochirí", map);

        map = new HashMap<String, String>();
        map.put("Huacho", "Huacho");
        map.put("Ámbar", "Ámbar");
        map.put("Caleta de Carquín", "Caleta de Carquín");
        map.put("Checras", "Checras");
        map.put("Hualmay", "Hualmay");
        map.put("Huaura", "Huaura");
        map.put("Leoncio Prado", "Leoncio Prado");
        map.put("Paccho", "Paccho");
        map.put("Santa Leonor", "Santa Leonor");
        map.put("Santa María", "Santa María");
        map.put("Sayán", "Sayán");
        map.put("Végueta", "Végueta");
        data.put("Huaura", map);

        map = new HashMap<String, String>();
        map.put("Lima", "Lima");
        map.put("Ancón", "Ancón");
        map.put("Ate", "Ate");
        map.put("Barranco", "Barranco");
        map.put("Breña", "Breña");
        map.put("Carabayllo", "Carabayllo");
        map.put("Chaclacayo", "Chaclacayo");
        map.put("Chorrillos", "Chorrillos");
        map.put("Cieneguilla", "Cieneguilla");
        map.put("Comas", "Comas");
        map.put("El Agustino", "El Agustino");
        map.put("Independencia", "Independencia");
        map.put("Jesús María", "Jesús María");
        map.put("La Molina", "La Molina");
        map.put("La Victoria", "La Victoria");
        map.put("Lince", "Lince");
        map.put("Los Olivos", "Los Olivos");
        map.put("Lurigancho-Chosica", "Lurigancho-Chosica");
        map.put("Lurín", "Lurín");
        map.put("Magdalena del Mar", "Magdalena del Mar");
        map.put("Lurín", "Lurín");
        map.put("Pueblo Libre", "Pueblo Libre");
        map.put("Miraflores", "Miraflores");
        map.put("Pachacámac", "Pachacámac");
        map.put("Pucusana", "Pucusana");
        map.put("Puente Piedra", "Puente Piedra");
        map.put("Punta Hermosa", "Punta Hermosa");
        map.put("Punta Negra", "Punta Negra");
        map.put("Rímac", "Rímac");
        map.put("San Bartolo", "San Bartolo");
        map.put("San Borja", "San Borja");
        map.put("San Isidro", "San Isidro");
        map.put("San Juan de Lurigancho", "San Juan de Lurigancho");
        map.put("San Juan de Miraflores", "San Juan de Miraflores");
        map.put("San Luis", "San Luis");
        map.put("San Martín de ", "San Martín de Porres");
        map.put("San Miguel", "San Miguel");
        map.put("Santa Anita", "Santa Anita");
        map.put("Santa María del Mar", "Santa María del Mar");
        map.put("Santa Rosa", "Santa Rosa");
        map.put("Santiago de Surco", "Santiago de Surco");
        map.put("Surquillo", "Surquillo");
        map.put("Villa el Salvador", "Villa el Salvador");
        map.put("Villa María del Triunfo", "Villa María del Triunfo");
        data.put("Lima", map);

        map = new HashMap<String, String>();
        map.put("Oyón", "Oyón");
        map.put("Andajes", "Andajes");
        map.put("Caujul", "Caujul");
        map.put("Cochamarca", "Cochamarca");
        map.put("Naván", "Naván");
        map.put("Pachangara", "Pachangara");
        data.put("Oyon", map);

        map = new HashMap<String, String>();
        map.put("Yauyos", "Yauyos");
        map.put("Alis", "Alis");
        map.put("Ayauca", "Ayauca");
        map.put("Ayaviri", "Ayaviri");
        map.put("Azángaro", "Azángaro");
        map.put("Cacra", "Cacra");
        map.put("Carania", "Carania");
        map.put("Catahuasi", "Catahuasi");
        map.put("Choclos", "Choclos");
        map.put("Cochas", "Cochas");
        map.put("Colonia", "Colonia");
        map.put("Hongos", "Hongos");
        map.put("Huampara", "Huampara");
        map.put("Huancaya", "Huancaya");
        map.put("Huangáscar", "Huangáscar");
        map.put("Huantán", "Huantán");
        map.put("Huañec", "Huañec");
        map.put("Laraos", "Laraos");
        map.put("Lincha", "Lincha");
        map.put("Madean", "Madean");
        map.put("Miraflores", "Miraflores");
        map.put("Omas", "Omas");
        map.put("San Lorenzo de Putinza", "San Lorenzo de Putinza");
        map.put("Quinches", "Quinches");
        map.put("Quinocay", "Quinocay");
        map.put("San Joaquín", "San Joaquín");
        map.put("San Pedro de Pilas Tanta", "San Pedro de Pilas Tanta");
        map.put("Tauripampa", "Tauripampa");
        map.put("Tomas", "Tomas");
        map.put("Tupe", "Tupe");
        map.put("Viñac", "Viñac");
        map.put("Vitis", "Vitis");
        data.put("Yauyos", map);
    }
    /*ruc*/

    public BigInteger getDni() {
        return dni;
    }

    public void setDni(BigInteger dni) {
        this.dni = dni;
    }

    /*ruc*/
    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Map<String, String> getProvincias() {
        return provincias;
    }

    public Map<String, String> getDistritos() {
        return distritos;
    }

    public void onProvinciaChange() {
        if (provincia != null && !provincia.equals("")) {
            distritos = data.get(provincia);
        } else {
            distritos = new HashMap<String, String>();
        }

    }

    public void eliminarDeudor() {
        addMessage("System Error", "Please try again later.");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String guardarDeudor() {
        return "Cliente guardado";
    }
}
