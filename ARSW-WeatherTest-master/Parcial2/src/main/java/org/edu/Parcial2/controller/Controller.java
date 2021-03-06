package org.edu.Parcial2.controller;

import org.edu.Parcial2.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.UUID;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    ServiceW servicios;

    @ResponseBody
    @GetMapping(value="/clima/{name}")
    public ResponseEntity<?> getCity(@PathVariable("name") String name) {
        try {
            String consulta;
            consulta = servicios.getWeather(name);
            return new ResponseEntity<>(consulta,HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("ERROR 404 NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

}