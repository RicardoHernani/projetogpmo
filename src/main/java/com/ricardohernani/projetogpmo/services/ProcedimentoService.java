package com.ricardohernani.projetogpmo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardohernani.projetogpmo.domain.Procedimento;
import com.ricardohernani.projetogpmo.repositories.ProcedimentoRepository;
import com.ricardohernani.projetogpmo.services.exceptions.ObjectNotFoundException;

@Service
public class ProcedimentoService {

	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public Procedimento find(Integer id) {
		Optional<Procedimento> obj = procedimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + Procedimento.class.getName()));
	}
	
	
	public void delete(Integer id) {
		find(id);
		procedimentoRepository.deleteById(id);
	}
}
