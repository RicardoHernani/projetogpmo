package com.ricardohernani.projetogpmo.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardohernani.projetogpmo.domain.Paciente;

@RestController
@RequestMapping(value="pacientes")
public class PacienteResource {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Paciente> listar() throws ParseException {
		
		Paciente pcte1 = new Paciente(1, 32144881, new java.util.Date(sdf.parse("29/12/2020").getTime()));
		Paciente pcte2 = new Paciente(2, 12345678, new java.util.Date(sdf.parse("23/01/2021").getTime()));
		
		List<Paciente> lista = new ArrayList<>();
		lista.add(pcte1);
		lista.add(pcte2);
		
		return lista;
	}
	
}
