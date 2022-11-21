
package br.projetodenunciaweb.interfacee.servico;

import java.util.ArrayList;


import br.projetodenunciaweb.entidade.Crime;


public interface ICrimeServico {
	
	
	public void cadastrarCrime(String descricao) throws Exception;
	
	public ArrayList<Crime> listarCrimes();
	public Crime listarCrimePeloCodigo(long codigo);
	public void alterarCrime (Crime crime);
}
