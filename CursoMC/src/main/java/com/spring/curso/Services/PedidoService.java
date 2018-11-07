package com.spring.curso.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.curso.Services.exception.ObjectNotFoundException;
import com.spring.curso.domain.Pedido;
import com.spring.curso.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Pedido.class.getName()));
		
	}
}
