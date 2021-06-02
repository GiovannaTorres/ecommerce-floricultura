package com.generation.floricultura.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_tipo")
public class Tipo {
	
	//atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min=3, max=30)
	private String tipo;
	
	
	//relacionamento com tabela Planta
	
	@OneToMany(mappedBy="tipo", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("tipo")
	private List<Planta> planta;
	
	
	//getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public List<Planta> getPlanta() {
		return planta;
	}

	public void setPlanta(List<Planta> planta) {
		this.planta = planta;
	}

}
