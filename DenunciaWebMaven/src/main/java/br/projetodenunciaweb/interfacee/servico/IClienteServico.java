
package br.projetodenunciaweb.interfacee.servico;

import java.util.ArrayList;
import java.util.List;
import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.entidade.Denuncia;
import br.projetodenunciaweb.entidade.Endereco;
import br.projetodenunciaweb.excecoes.ExcecaoCliente;

public interface IClienteServico {
	
	
	public void cadastrarCliente(String nome, String cPF, String email, Endereco endereco) throws ExcecaoCliente;
	
	public void cadastrarCliente(String nome, String cPF, String email, Endereco endereco, List<Denuncia> denuncias) throws ExcecaoCliente;
	public void alterarCliente(String nome, String cPF, String email, Endereco endereco, List<Denuncia> denuncias);
	public void alterarCliente(Cliente cliente);
	public void removerCliente(int codigo);
	public Cliente listarClientePeloCodigo(long codigo);
	public ArrayList<Cliente> listarClientes();

}
