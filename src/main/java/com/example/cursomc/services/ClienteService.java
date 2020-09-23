package com.example.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domain.Cliente;
import com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {

		Optional<Cliente> obj = repo.findById(id);

		//if (obj == null) {
			//throw new ObjectNotFoundException("Objeto não encontrado :" + id + " Tipo" + Cliente.class.getName());
		//}

		//return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id + " Tipo: " + Cliente.class.getName()));
	}

}
