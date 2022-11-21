
package br.projetodenunciaweb.servicos;


import java.util.ArrayList;

import br.projetodenunciaweb.entidade.Denuncia;
import br.projetodenunciaweb.excecoes.ExcecaoCliente;
import br.projetodenunciaweb.interfacee.servico.IDenunciaServico;
import br.projetodenunciaweb.repositorio.DenunciaRepositorio;

public class ServicoDenuncia implements IDenunciaServico {
	private DenunciaRepositorio denunciaRepositorioBd;

	public ServicoDenuncia() {

		this.denunciaRepositorioBd = new DenunciaRepositorio();

	}

//	@Override
//	public ArrayList<Denuncia> consultarPorIdCliente(long idCliente) throws ExcecaoDenuncia {
//		return this.denunciaRepositorioBd.consultarPorIdCliente(idCliente);
//	}

	@Override
	public void alterar(String idCliente, String altura, String proximidade,
			String etnia, String dataHora, String local, String tipoViolencia) {

		Denuncia denuncia = new Denuncia(idCliente, dataHora, local, etnia, proximidade, altura, tipoViolencia);
		this.denunciaRepositorioBd.alterar(denuncia);

	}

//	@Override
//	public void excluir(Denuncia denuncia) {
//		this.denunciaRepositorioBd.excluir(denuncia);
//		
//	}

	@Override
	public ArrayList<Denuncia> listarTodas() {
		return this.denunciaRepositorioBd.listarTodas();
	}

	@Override
	public ArrayList<Denuncia> listarDenuncaPorCliente(String idCliente) {
		return this.denunciaRepositorioBd.listarDenuncaPorCliente(idCliente);
	}

	@Override
	public void cadastrar(String idCliente, String dataHora, String local, String etnia,
			String proximidade, String altura, String tipoViolencia) {
		try {

			Denuncia denunciaAdd = new Denuncia(idCliente, dataHora, local, etnia, proximidade, altura, tipoViolencia);

			this.denunciaRepositorioBd.salvar(denunciaAdd);

			System.out.println("A DENUNCIA FOI CADASTRADA COM SUCESSO!!!!");
		} catch (Exception e) {
			System.out.println("ERRO AO CADASTRAR A DENUNCIA... " + e.getMessage());
		}
	}

	@Override
	public Denuncia listarPorCodigo(long codigo) {
		return this.denunciaRepositorioBd.buscar(codigo);
	}

	@Override
	public void alterar(Denuncia denuncia) {
		try {
			if (denuncia.getLocal().length() < 4)
				throw new ExcecaoCliente("LOCAL ESTÁ INVÁLIDO!!!");

			if (this.denunciaRepositorioBd.alterar(denuncia))
				System.out.println("A DENUNCIA FOI ALTERADA COM SUCESSO");
		} catch (Exception e) {
			System.out.println("ERRO AO ALTERAR OS DADOS DA DENUNCIA... " + e.getMessage());
		}
	}
}
