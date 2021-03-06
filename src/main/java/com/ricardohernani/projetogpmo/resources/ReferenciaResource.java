package com.ricardohernani.projetogpmo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardohernani.projetogpmo.domain.Referencia;
import com.ricardohernani.projetogpmo.services.ReferenciaService;

@RestController
@RequestMapping(value="/referencias")
public class ReferenciaResource {

	@Autowired
	private ReferenciaService service;
	
	@RequestMapping (value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<Referencia> find(@PathVariable Integer codigo) {
		Referencia obj = service.find(codigo);
		return ResponseEntity.ok().body(obj);
	}
	
}
