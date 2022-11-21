package br.projetodenunciaweb.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Crimes")
public class Crime extends DominioGeral {
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public Crime() {}

	public Crime(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
