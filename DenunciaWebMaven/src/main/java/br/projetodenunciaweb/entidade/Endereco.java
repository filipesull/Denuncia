package br.projetodenunciaweb.entidade;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "endereco")

	public class Endereco extends DominioGeral {
	protected String bairro;
	protected String cidade;
	protected String estado;
	protected String numero;
	
	public Endereco() {}
	public Endereco(String bairro, String cidade, String estado, String numero) {
		super();
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
