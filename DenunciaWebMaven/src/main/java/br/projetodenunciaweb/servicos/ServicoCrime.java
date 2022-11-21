
package br.projetodenunciaweb.servicos;

import java.util.ArrayList;

import br.projetodenunciaweb.entidade.Crime;
import br.projetodenunciaweb.excecoes.ExcecaoCrime;
import br.projetodenunciaweb.interfacee.servico.ICrimeServico;
import br.projetodenunciaweb.repositorio.CrimeRepositorio;


public class ServicoCrime implements ICrimeServico {

	private CrimeRepositorio crimeRepositorioBd;

	public ServicoCrime() {

		this.crimeRepositorioBd = new CrimeRepositorio();
	}
	
	@Override
	public void cadastrarCrime(String descricao) throws Exception {
		try {
			
			Crime crimeAdd = new Crime(descricao);
			if(descricao == "")
				throw new Exception("DESCRIÇÃO STATUS: VAZIA");
		;
			this.crimeRepositorioBd.salvar(crimeAdd);			
			 
			System.out.println("O CRIME FOI CADASTRADO COM SUCESSO!!!!");
		} catch (Exception e) {
			System.out.println("ERRO AO CADASTRAR O CRIME... "+e.getMessage());
		}	
	}
	
	@Override
	public void alterarCrime(Crime crime) {
		try {
			if (crime.getDescricao().length() < 4)
				throw new ExcecaoCrime("DESCRICAO ESTÁ INVÁLIDA!!!");

			if (this.crimeRepositorioBd.alterar(crime))
				System.out.println("O CRIME FOI ALTERADO COM SUCESSO");
		} catch (Exception e) {
			System.out.println("ERRO AO ALTERAR OS DADOS DO CRIME... " + e.getMessage());
		}
	}

	@Override
	public Crime listarCrimePeloCodigo(long codigo) {
		return this.crimeRepositorioBd.buscar(codigo);
		
	}
	@Override
	public ArrayList<Crime> listarCrimes() {
		ArrayList<Crime> crime = new ArrayList<Crime>(this.crimeRepositorioBd.listarTodos());
		return crime;
	}

	
}
