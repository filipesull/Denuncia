
package br.projetodenunciaweb.servicos;

import java.util.ArrayList;
import java.util.List;

import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.entidade.Denuncia;
import br.projetodenunciaweb.entidade.Endereco;
import br.projetodenunciaweb.excecoes.ExcecaoCliente;
import br.projetodenunciaweb.interfacee.servico.IClienteServico;
import br.projetodenunciaweb.repositorio.ClienteRepositorio;

public class ServicoCliente implements IClienteServico {

	private ClienteRepositorio clienteRepositorioBd;

	public ServicoCliente() {

		this.clienteRepositorioBd = new ClienteRepositorio();
	}
	
	@Override
	public void cadastrarCliente(String nome, String cPF, String email, Endereco endereco) throws ExcecaoCliente {
		try {
			
			Cliente clienteAdd = new Cliente(nome, cPF, email, endereco);
			if(nome == "")
				throw new ExcecaoCliente("NOME STATUS: NULL");
			if(cPF == "")
				throw new ExcecaoCliente("CPF STATUS: NULL");
			this.clienteRepositorioBd.salvar(clienteAdd);			
			 
			System.out.println("O CLIENTE FOI CADASTRADO COM SUCESSO!!!!");
		} catch (Exception e) {
			System.out.println("ERRO AO CADASTRAR O CLIENTE... "+e.getMessage());
		}	
	}
	
	@Override
	public void cadastrarCliente(String nome, String cPF, String email, Endereco endereco, List<Denuncia> denuncias) throws ExcecaoCliente {
		try {
			
			Cliente clienteAdd = new Cliente(nome, cPF, email, endereco, denuncias);
			if(nome == null)
				throw new ExcecaoCliente("NOME STATUS: NULL");
			if(cPF == null)
				throw new ExcecaoCliente("CPF STATUS: NULL");
			this.clienteRepositorioBd.salvar(clienteAdd);			
			 
			System.out.println("O CLIENTE FOI CADASTRADO COM SUCESSO!!!!");
		} catch (Exception e) {
			System.out.println("ERRO AO CADASTRAR O CLIENTE... "+e.getMessage());
		}	
	}
	
	@Override
	public void alterarCliente(String nome, String cPF, String email, Endereco endereco,  List<Denuncia> denuncias) {
		try {
				Cliente clienteAdd = new Cliente(nome, cPF, email, endereco, denuncias);
				
				if(this.clienteRepositorioBd.alterar(clienteAdd))		 
					System.out.println("CLIENTE ALTERADO COM SUCESSO");
				else				
					System.out.println("CLIENTE NAO ENCONTRADO... ");
		} catch (Exception e) {
			System.out.println("ERRO AO ALTERAR OS DADOS DO CLIENTE... "+e.getMessage());
		}		
	}

	
	@Override
	public void alterarCliente(Cliente cliente) {
		try {
			if (cliente.getNome().length() < 4)
				throw new ExcecaoCliente("NOME ESTÁ INVÁLIDO!!!");

			if (this.clienteRepositorioBd.alterar(cliente))
				System.out.println("O CLIENTE FOI ALTERADO COM SUCESSO");
		} catch (Exception e) {
			System.out.println("ERRO AO ALTERAR OS DADOS DO CLIENTE... " + e.getMessage());
		}
	}

	
	@Override
	public void removerCliente(int codigo) {
	
	}

	
	@Override
	public Cliente listarClientePeloCodigo(long codigo) {
		return this.clienteRepositorioBd.buscar(codigo);
	}

	
	@Override
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>(this.clienteRepositorioBd.listarTodos());
		return clientes;
	}
	
}
