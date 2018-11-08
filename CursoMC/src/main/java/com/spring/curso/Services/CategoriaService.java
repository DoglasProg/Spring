package com.spring.curso.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.spring.curso.Services.exception.ObjectNotFoundException;
import com.spring.curso.domain.Categoria;
import com.spring.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	//a dependência vai ser automaticamente instanciada pelo Spring
	
	public Categoria find(Integer id) {
		//Optional container para encapsular Categoria, solução para erro null
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			
		repo.deleteById(id); 
		
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityViolationException("Não é possivel excluir uma categoria que possui produtos");
		}
		
	}
}
