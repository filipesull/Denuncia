
package br.projetodenunciaweb.interfacee.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.projetodenunciaweb.entidade.Denuncia;
import br.projetodenunciaweb.excecoes.ExcecaoDenuncia;


public interface IDenunciaRepositorio {
	public void salvar(Denuncia deduncia);
	public ArrayList<Denuncia> consultarPorIdCliente(long idCliente) throws ExcecaoDenuncia;
	public boolean alterar(Denuncia denuncia);
	public void excluir(Denuncia denuncia);
	public List<Denuncia> listar();
	public Denuncia buscar(long id);
	
	boolean cadastrar(String alturaAg, String proximidadeAg, String etniaAg, String dataHora, String local,
			String tipoViolenciaAg);
	
	public ArrayList<Denuncia> listarTodas();
	
	public ArrayList<Denuncia> listarDenuncaPorCliente(String idCliente);
}

