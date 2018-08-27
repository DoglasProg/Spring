package com.spring.curso.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.curso.Services.CategoriaService;
import com.spring.curso.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CateegoriaResouce {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		//anotação para indicar que recebe um argumento
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
