package com.ricardohernani.projetogpmo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardohernani.projetogpmo.domain.Paciente;
import com.ricardohernani.projetogpmo.repositories.PacienteRepository;

@SpringBootApplication
public class ProjetogpmoApplication implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetogpmoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Paciente pcte1 = new Paciente(null, 32144881, new java.util.Date(sdf.parse("29/12/2020").getTime()));
		Paciente pcte2 = new Paciente(null, 12345678, new java.util.Date(sdf.parse("23/01/2021").getTime()));
		
		pacienteRepository.saveAll(Arrays.asList(pcte1, pcte2));
	}

}
