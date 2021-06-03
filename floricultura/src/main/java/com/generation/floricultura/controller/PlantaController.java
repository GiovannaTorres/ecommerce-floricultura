package com.generation.floricultura.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.floricultura.model.Planta;
import com.generation.floricultura.repository.PlantaRepository;

@RestController
@RequestMapping("/plantas")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PlantaController {

	@Autowired
	private PlantaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Planta>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Planta> getById(@PathVariable long id){
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
										.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/especie/{especie}")
	public ResponseEntity <List<Planta>> getByEspecie(@PathVariable String especie){
		return ResponseEntity.ok(repository.findAllByEspecieContainingIgnoreCase(especie));
	}
	
	@GetMapping("/valor/{valor}")
	public ResponseEntity <List<Planta>> getByValor(@PathVariable BigDecimal valor){
		return ResponseEntity.ok(repository.findByValor(valor));
	}
	
	@GetMapping("/valor/<{valor}")
	public ResponseEntity <List<Planta>> getByValorLessThanEqual(@PathVariable BigDecimal valor){
		return ResponseEntity.ok(repository.findByValorLessThanEqual(valor));
	}	
	
	@PostMapping
	public ResponseEntity<Planta> post (@RequestBody Planta plantinha){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(plantinha));
	}
	
	@PutMapping
	public ResponseEntity <Planta> put (@RequestBody Planta plantinha) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(plantinha));
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

	
}
