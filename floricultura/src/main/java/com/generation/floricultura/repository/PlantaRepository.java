package com.generation.floricultura.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.floricultura.model.Planta;

@Repository
public interface PlantaRepository extends JpaRepository <Planta, Long> {
	
	public List<Planta> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Planta> findAllByEspecieContainingIgnoreCase(String especie);
	
	public List<Planta> findAllByValorContaining(BigDecimal valor);

}
