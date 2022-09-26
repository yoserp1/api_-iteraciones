package com.test.iteraccion.app.arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ArraysController {
	
    @Autowired
    private ArraysService service;
	
    @GetMapping
    public ArraysDTO iteraccion(
		@RequestParam(name = "pila") Long pila,
		@RequestParam(name = "iteraccion") Integer iteraccion){
    	return this.service.iteraccion(pila, iteraccion);
    }

}
