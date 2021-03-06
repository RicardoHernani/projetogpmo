package com.ricardohernani.projetogpmo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardohernani.projetogpmo.domain.Paciente;
import com.ricardohernani.projetogpmo.dto.PacienteNewDTO;
import com.ricardohernani.projetogpmo.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteService service;
	
	@RequestMapping (value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Paciente> find(@PathVariable Integer id) {
		Paciente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Paciente obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	*/
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> uptade(@RequestBody Paciente obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping (value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PacienteNewDTO objDto) {
		Paciente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
}
