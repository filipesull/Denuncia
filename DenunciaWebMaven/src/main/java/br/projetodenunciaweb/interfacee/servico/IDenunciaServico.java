
package br.projetodenunciaweb.interfacee.servico;

import java.util.ArrayList;

import br.projetodenunciaweb.entidade.Denuncia;


public interface IDenunciaServico {
	public void cadastrar(String idCliente, String dataHora, String local, String etnia,String proximidade, String altura, String tipoViolencia);
	public void alterar(String idCliente, String altura, String proximidade, String etnia, String dataHora, String local, String tipoViolencia);
	public void alterar(Denuncia denuncia);
	public Denuncia listarPorCodigo(long codigo);
	public ArrayList<Denuncia> listarTodas();
	public ArrayList<Denuncia> listarDenuncaPorCliente(String idCliente);

}
