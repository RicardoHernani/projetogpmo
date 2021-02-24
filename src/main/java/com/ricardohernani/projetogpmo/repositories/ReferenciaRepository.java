package com.ricardohernani.projetogpmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardohernani.projetogpmo.domain.Referencia;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, Integer>{

}
