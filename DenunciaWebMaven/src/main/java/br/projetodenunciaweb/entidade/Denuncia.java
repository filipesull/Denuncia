
package br.projetodenunciaweb.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Denuncia extends DominioGeral {

	@Column(length = 50, nullable = false)
	private String idCliente;
	
	@Column(length = 50, nullable = false)
	private String dataHora;
	
	@Column(length = 50, nullable = false)
	private String local;
	
	@Column(length = 50, nullable = false)
	private String etnia;

	@Column(length = 50, nullable = false)
	private String proximidade;
	
	@Column(length = 50, nullable = false)
	private String altura;

	@Column(length = 50, nullable = false)
	private String tipoViolencia;
	

	public Denuncia(String idCliente, String dataHora, String local, String etnia,
			String proximidade, String altura, String tipoViolencia	) {
		super();
		this.idCliente = idCliente;
		this.dataHora = dataHora;
		this.local = local;
		this.etnia = etnia;
		this.proximidade = proximidade;
		this.altura = altura;
		this.tipoViolencia = tipoViolencia;
	}

	public Denuncia() {
		super();
	}
	
	public String getEtnia() {
		return etnia;
	}
	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}
	public String getProximidade() {
		return proximidade;
	}
	public void setProximidade(String proximidade) {
		this.proximidade = proximidade;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getTipoViolencia() {
		return tipoViolencia;
	}
	public void setTipoViolencia(String tipoViolencia) {
		this.tipoViolencia = tipoViolencia;
	}	
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}

	public void setCliente(Cliente cliente) {
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

}
