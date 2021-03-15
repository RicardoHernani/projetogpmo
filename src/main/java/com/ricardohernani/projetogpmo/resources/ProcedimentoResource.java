package com.ricardohernani.projetogpmo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardohernani.projetogpmo.services.ProcedimentoService;

@RestController
@RequestMapping(value="/pacientes")
public class ProcedimentoResource {

	
	@Autowired
	private ProcedimentoService service;
	
	@RequestMapping (value="/{id}/procedimentos/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
