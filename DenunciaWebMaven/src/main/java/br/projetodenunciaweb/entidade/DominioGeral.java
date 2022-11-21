package br.projetodenunciaweb.entidade;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") 
@MappedSuperclass

public abstract class DominioGeral implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}