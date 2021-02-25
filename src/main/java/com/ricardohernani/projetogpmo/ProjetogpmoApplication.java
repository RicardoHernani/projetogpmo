package com.ricardohernani.projetogpmo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardohernani.projetogpmo.domain.Paciente;
import com.ricardohernani.projetogpmo.domain.Procedimento;
import com.ricardohernani.projetogpmo.domain.Referencia;
import com.ricardohernani.projetogpmo.repositories.PacienteRepository;
import com.ricardohernani.projetogpmo.repositories.ProcedimentoRepository;
import com.ricardohernani.projetogpmo.repositories.ReferenciaRepository;

@SpringBootApplication
public class ProjetogpmoApplication implements CommandLineRunner {

	@Autowired
	private ReferenciaRepository referenciaRepository;
	
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
		
		Referencia ref1 = new Referencia(31102360, "ureterorrenolitotripsia flexível", 41.67, 297.83);
		Referencia ref2 = new Referencia(31102077, "colocação de duplo j", 20.00, 112.56);
		Referencia ref3 = new Referencia(30908027, "fístula arteriovenosa", 27.78, 195.07);
		Referencia ref4 = new Referencia(30202094, "palatoplastia com enxerto ósseo", 33.33, 717.27);
		
		Procedimento proc1 = new Procedimento(null, 1, 1, pcte1, ref1);
		Procedimento proc2 = new Procedimento(null, 2, 1, pcte1, ref2);
		Procedimento proc3 = new Procedimento(null, 1, 1, pcte1, ref2);
		Procedimento proc4 = new Procedimento(null, 1, 2, pcte2, ref3);
		
		
		pcte1.getProcedimentos().addAll(Arrays.asList(proc1,proc2,proc3));
		pcte2.getProcedimentos().addAll(Arrays.asList(proc4));
		
		referenciaRepository.saveAll(Arrays.asList(ref1, ref2, ref3, ref4));
		pacienteRepository.saveAll(Arrays.asList(pcte1, pcte2));
		procedimentoRepository.saveAll(Arrays.asList(proc1, proc2, proc3, proc4));
		
		
	}

}
