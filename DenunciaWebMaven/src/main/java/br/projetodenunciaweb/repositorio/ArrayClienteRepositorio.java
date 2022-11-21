
package br.projetodenunciaweb.repositorio;

import java.util.ArrayList;

import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.interfacee.repositorio.IClienteRepositorio;

	public class ArrayClienteRepositorio  implements IClienteRepositorio{
		private ArrayList<Cliente> clientesRepositorio;
		 
		public ArrayClienteRepositorio(ArrayList<Cliente> repoClientes) {
			 
			this.clientesRepositorio = repoClientes;
		}

		@Override
		public void salvar(Cliente cliente) {
			this.clientesRepositorio.add(cliente);	
			
		}

		@Override
		public boolean alterar(Cliente cliente) {
			for (Cliente clienteB : clientesRepositorio) {
				if(clienteB.getCPF().equals(cliente.getCPF())) {
					clienteB=cliente;
					return true;				
				}				
			}
			return false;
		}

		@Override
		public void remover(Cliente cliente) {
			for (Cliente clienteB : clientesRepositorio) {
				if(clienteB.getCPF().equals(cliente.getCPF())) {
					clientesRepositorio.remove(cliente); 
					break;				
				}			
			}		
			
		}

		@Override
		public ArrayList<Cliente> listarTodos() {
			return clientesRepositorio;
		}

		@Override
		public Cliente buscar(long id) {
			return null;
		}



	}
