package com.spring.curso.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.curso.domain.Cliente;
import com.spring.curso.repositories.ClienteRepository;
import com.spring.curso.security.UserSecurity;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cli= repo.findByEmail(email);
		if(cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSecurity(cli.getId(),cli.getEmail(),cli.getSenha(),cli.getPerfis());
	}

}
