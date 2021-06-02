package com.generation.floricultura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.floricultura.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
	
	public List<Tipo> findAllByTipoContainingIgnoreCase(String tipo);
}
