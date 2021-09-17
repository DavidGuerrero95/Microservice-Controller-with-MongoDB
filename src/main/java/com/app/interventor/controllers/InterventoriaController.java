package com.app.interventor.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.interventor.models.Interventoria;
import com.app.interventor.repository.InterventoriaRepository;

@RestController
public class InterventoriaController {

	@Autowired
	InterventoriaRepository interventoriaRepository;
	
	@PostMapping("/interventor/crearUsuarios")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void crearUsuarios() {
		Interventoria interventoria = new Interventoria();
		interventoria.setNombre("usuarios");
		interventoria.setListaNombre(new ArrayList<String>());
		interventoria.setPosiciones(new ArrayList<Integer>());
		interventoriaRepository.save(interventoria);
	}
	
	@PostMapping("/interventor/crearProyectos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void crearProyectos() {
		Interventoria interventoria = new Interventoria("proyectos", new ArrayList<String>(), new ArrayList<Integer>());
		interventoriaRepository.save(interventoria);
	}
	
	@PutMapping("/interventor/peticionEliminarUsuario")
	@ResponseStatus(code = HttpStatus.OK)
	public void peticionEliminarUsuario(@RequestParam String username) {
		Interventoria interventoria = interventoriaRepository.findByNombre("usuarios");
		List<String> listaUsuarios = interventoria.getListaNombre();
		listaUsuarios.add(username);
		interventoria.setListaNombre(listaUsuarios);
		interventoriaRepository.save(interventoria);
	}
	
	@PutMapping("/interventor/peticionEliminarProyecto")
	@ResponseStatus(code = HttpStatus.OK)
	public void peticionEliminarProyecto(@RequestParam String name) {
		Interventoria interventoria = interventoriaRepository.findByNombre("proyectos");
		List<String> listaUsuarios = interventoria.getListaNombre();
		listaUsuarios.add(name);
		interventoria.setListaNombre(listaUsuarios);
		interventoriaRepository.save(interventoria);
	}
	
	@GetMapping("/interventor/listaUsuarios")
	@ResponseStatus(code = HttpStatus.OK)
	public List<String> listaUsuarios(){
		Interventoria interventoria = interventoriaRepository.findByNombre("usuarios");
		return interventoria.getListaNombre();
	}
	
	@GetMapping("/interventor/listaProyectos")
	@ResponseStatus(code = HttpStatus.OK)
	public List<String> listaProyectos(){
		Interventoria interventoria = interventoriaRepository.findByNombre("proyectos");
		return interventoria.getListaNombre();
	}
	
}
