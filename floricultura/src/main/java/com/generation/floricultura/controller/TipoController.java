package com.generation.floricultura.controller;

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

import com.generation.floricultura.model.Tipo;
import com.generation.floricultura.repository.TipoRepository;

@RestController
@RequestMapping("/tipos")
@CrossOrigin(origins="*", allowedHeaders="*")
public class TipoController {
	
	@Autowired
	public TipoRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Tipo>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Tipo> getById(@PathVariable long id){
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity <Tipo> post (@RequestBody Tipo tipoDePlanta){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipoDePlanta));
	}
	
	@PutMapping
	public ResponseEntity <Tipo> put (@RequestBody Tipo tipoDePlanta){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tipoDePlanta));
	}

	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
