package com.app.interventor.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "interventor")
public class Interventoria {

	@Id
	private String id;

	@Indexed(unique = true)
	private String nombre;

	private List<String> listaNombre;

	private List<Integer> posiciones;

	public Interventoria() {
		super();
	}

	public Interventoria(String nombre, List<String> listaNombre, List<Integer> posiciones) {
		super();
		this.nombre = nombre;
		this.listaNombre = listaNombre;
		this.posiciones = posiciones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getListaNombre() {
		return listaNombre;
	}

	public void setListaNombre(List<String> listaNombre) {
		this.listaNombre = listaNombre;
	}

	public List<Integer> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<Integer> posiciones) {
		this.posiciones = posiciones;
	}

}
