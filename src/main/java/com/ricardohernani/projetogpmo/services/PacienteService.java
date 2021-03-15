package com.ricardohernani.projetogpmo.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardohernani.projetogpmo.domain.Paciente;
import com.ricardohernani.projetogpmo.domain.Procedimento;
import com.ricardohernani.projetogpmo.domain.Referencia;
import com.ricardohernani.projetogpmo.dto.PacienteNewDTO;
import com.ricardohernani.projetogpmo.repositories.PacienteRepository;
import com.ricardohernani.projetogpmo.repositories.ProcedimentoRepository;
import com.ricardohernani.projetogpmo.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
		
	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}
		
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		procedimentoRepository.saveAll(obj.getProcedimentos());
		return obj;
	}
	
	public Paciente update(Paciente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public Paciente fromDTO(PacienteNewDTO objDto) {
		Paciente pct = new Paciente(null, objDto.getRegistro(), objDto.getData());
		
		Referencia ref = new Referencia(objDto.getCodigo(), null, null,null);
		Procedimento pro = new Procedimento(null, objDto.getTipo(), objDto.getPremio(), pct, ref);
		pct.getProcedimentos().addAll(Arrays.asList(pro));
		
		
		if (objDto.getCodigo1()!=null) {
		Referencia ref1 = new Referencia(objDto.getCodigo1(), null, null, null);
		Procedimento pro1 = new Procedimento(null, objDto.getTipo1(), objDto.getPremio1(), pct, ref1);
		pct.getProcedimentos().addAll(Arrays.asList(pro1));
		}
		
		return pct;
	}
}
