package com.ricardohernani.projetogpmo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardohernani.projetogpmo.domain.Paciente;
import com.ricardohernani.projetogpmo.repositories.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;

	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
