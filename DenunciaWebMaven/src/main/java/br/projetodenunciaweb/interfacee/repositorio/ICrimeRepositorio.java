

package br.projetodenunciaweb.interfacee.repositorio;

import java.util.ArrayList;

import br.projetodenunciaweb.entidade.Crime;

public interface ICrimeRepositorio {
	public void salvar(Crime crime);
	public ArrayList<Crime> listarTodos();
	public Crime buscar(long id);
	public boolean alterar(Crime crime);
}
