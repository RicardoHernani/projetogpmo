package com.ricardohernani.projetogpmo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardohernani.projetogpmo.domain.Paciente;
import com.ricardohernani.projetogpmo.domain.Procedimento;
import com.ricardohernani.projetogpmo.repositories.PacienteRepository;
import com.ricardohernani.projetogpmo.repositories.ProcedimentoRepository;

@SpringBootApplication
public class ProjetogpmoApplication implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetogpmoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Paciente pcte1 = new Paciente(null, 32144881, new java.util.Date(sdf.parse("29/12/2020").getTime()));
		Paciente pcte2 = new Paciente(null, 12345678, new java.util.Date(sdf.parse("23/01/2021").getTime()));
		
		Procedimento proc1 = new Procedimento(null, 1, 1, pcte1);
		Procedimento proc2 = new Procedimento(null, 2, 1, pcte1);
		Procedimento proc3 = new Procedimento(null, 1, 1, pcte1);
		Procedimento proc4 = new Procedimento(null, 1, 2, pcte2);
		
		pcte1.getProcedimentos().addAll(Arrays.asList(proc1,proc2,proc3));
		pcte2.getProcedimentos().addAll(Arrays.asList(proc4));
		
		pacienteRepository.saveAll(Arrays.asList(pcte1, pcte2));
		procedimentoRepository.saveAll(Arrays.asList(proc1, proc2, proc3, proc4));
		
	}

}
