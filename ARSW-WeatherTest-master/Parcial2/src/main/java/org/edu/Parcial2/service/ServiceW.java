package org.edu.Parcial2.service;

import java.io.IOException;
import java.util.HashMap;

import org.edu.Parcial2.connection.*;
import org.springframework.stereotype.Service;
@Service
public class ServiceW {

    public static HashMap<String, String> cities;

    public String getWeather(String name) throws IOException {
        /*if (cities.get(name) == null) {
            String consulta;
            Connection.setCity(name);
            consulta = Connection.connection();
            cities.put(name, consulta);
            return consulta;
        } else {
            return cities.get(name);
        }*/

        String consulta;
        Connection.setCity(name);
        consulta = Connection.connection();
        return consulta;
    }

}