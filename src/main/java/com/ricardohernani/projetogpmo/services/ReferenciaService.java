package com.ricardohernani.projetogpmo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardohernani.projetogpmo.domain.Referencia;
import com.ricardohernani.projetogpmo.repositories.ReferenciaRepository;
import com.ricardohernani.projetogpmo.services.exceptions.ObjectNotFoundException;

@Service
public class ReferenciaService {
	
	@Autowired
	private ReferenciaRepository repo;

	public Referencia find(Integer codigo) {
		Optional<Referencia> obj = repo.findById(codigo);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrado! Código: " + codigo + ", Tipo: " + Referencia.class.getName()));
	}
	
}