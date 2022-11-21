package br.projetodenunciaweb.entidade;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

//	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Denuncia> denuncias;

	public Cliente() {
	}

	public Cliente(String nome, String cPF, String email, Endereco endereco, List<Denuncia> denuncias) {

		//this.denuncias = denuncias;
		this.nome = nome;
		this.CPF = cPF;
		this.email = email;

	}

	public Cliente(String nome, String cPF, String email, Endereco endereco) {
		this.nome = nome;
		this.CPF = cPF;
		this.email = email;

	}

//	public List<Denuncia> getDenuncias() {
//		return denuncias;
//	}
//
//	public void setDenuncias(List<Denuncia> denuncias) {
//		this.denuncias = denuncias;
//	}

}
