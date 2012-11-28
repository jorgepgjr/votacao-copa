package br.com.jorge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Mascote {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Long votos;
		
	public Mascote() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVotos() {
		return votos;
	}
	public void setVotos(Long votos) {
		this.votos = votos;
	}
}
