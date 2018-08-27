package com.spring.curso.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CateegoriaResouce {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest esta funcionando";
	}

}
