package com.test.iteraccion.app.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
	    String[] vasos = num.split(",");
	    int talla = vasos.length;
	    int divisor = 2;
	    List<Integer> arregloA = new ArrayList<>();
	    List<Integer> respuesta = new ArrayList<>();
	    List<Integer> primo = new ArrayList<>();

	    for (int j = 0; j < talla; j++) {
	    	int valor = Integer.parseInt(vasos[j]);
			if (valor % divisor == 0) {
				respuesta.add(valor);
			}
			if (valor % divisor != 0) {
				primo.add(valor);
			}
	    }
	    
	    for (int i = 1; i <= primo.size(); i++) {
	    	int ultimo = primo.get(primo.size() - i);
	    	arregloA.add(ultimo);
	    }
	    
	    Collections.sort(arregloA);
	    Collections.sort(respuesta, Collections.reverseOrder());
	    respuesta.addAll(arregloA);   
	    
	    String resultado = respuesta.stream().map(Object::toString).collect(Collectors.joining(","));
	    
	    return new ArraysDTO(resultado);

	}

}
