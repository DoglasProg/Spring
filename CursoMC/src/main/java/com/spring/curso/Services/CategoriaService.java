package com.spring.curso.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.curso.Services.exception.ObjectNotFoundException;
import com.spring.curso.domain.Categoria;
import com.spring.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	//a dependência vai ser automaticamente instanciada pelo Spring
	
	public Categoria buscar(Integer id) {
		//Optional container para encapsular Categoria, solução para erro null
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Categoria.class.getName()));
		
	}
}
