package com.ricardohernani.projetogpmo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardohernani.projetogpmo.domain.Paciente;
import com.ricardohernani.projetogpmo.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {

	
	
	@Autowired
	private PacienteService service;
	
	@RequestMapping (value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Paciente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
