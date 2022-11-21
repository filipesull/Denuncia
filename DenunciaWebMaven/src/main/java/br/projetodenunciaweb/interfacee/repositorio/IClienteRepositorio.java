
package br.projetodenunciaweb.interfacee.repositorio;

import java.util.ArrayList;

import br.projetodenunciaweb.entidade.Cliente;

public interface IClienteRepositorio {
	public void salvar(Cliente cliente);
	public boolean alterar(Cliente cliente);
	public void remover(Cliente cliente);
	public ArrayList<Cliente> listarTodos();
	public Cliente buscar(long id);
	


}
