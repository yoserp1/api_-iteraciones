package com.test.iteraccion.app.arrays;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArraysService {
	
	private final IArraysRepository repository;
	
	@Autowired
	public ArraysService(IArraysRepository repository) {
		Objects.requireNonNull(repository);
		this.repository = repository;
	}

	public ArraysDTO iteraccion(Long pila, Integer iteraccion) {
		if (this.repository.existsById(pila)) {
			return this.respuesta(this.repository.obtenerPorId(pila), iteraccion);
		}
		return null;
	}
	
	public ArraysDTO respuesta(ArraysDTO arraysDTO, Integer iteraccion) {
	    String num = arraysDTO.getOutput(); 
	    String[] respuesta = num.split(",");
	    int talla = respuesta.length;
	    int divisor = 2;   
	    int[] arregloA = {};
	    int[] arregloB = {};
	    for (int i = 0; i < iteraccion; i++) {
		    for (int j = 0; j < talla; j++) {
		    	int valor = Integer.parseInt(respuesta[j]);
				if (valor % divisor == 0) {
					System.out.println(valor + " es divisible entre 2 ");
				}
				if (valor % divisor != 0) {
					System.out.println(valor + " NO es divisible entre 2 ");
				}
		    	
		    }
	    }
		return arraysDTO;
	}

}
