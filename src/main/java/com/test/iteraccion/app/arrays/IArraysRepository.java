package com.test.iteraccion.app.arrays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.iteraccion.app.entity.Arrays;

@Repository
public interface IArraysRepository extends JpaRepository<Arrays, Long>{

	@Query(value = "select new com.test.iteraccion.app.arrays.ArraysDTO( a.inputArray) from Arrays a where a.id = :pila")
	ArraysDTO obtenerPorId(@Param("pila") Long pila);

}
