package com.app.interventor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.app.interventor.models.Interventoria;

import feign.Param;

public interface InterventoriaRepository extends MongoRepository<Interventoria, String>{

	@RestResource(path = "nombre")
	public Interventoria findByNombre(@Param("nombre") String nombre);
	
}
