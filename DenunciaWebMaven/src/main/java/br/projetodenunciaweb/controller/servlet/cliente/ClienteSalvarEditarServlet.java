package br.projetodenunciaweb.controller.servlet.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.servicos.ServicoCliente;

@WebServlet("/ClienteSalvarEditarServlet")

public class ClienteSalvarEditarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			String nome = req.getParameter("nome");
			String cpf = req.getParameter("cpf");
			String email = req.getParameter("email");
			String id = req.getParameter("id");

			ServicoCliente clienteServico = new ServicoCliente();
			Cliente cliente = clienteServico.listarClientePeloCodigo(Integer.parseInt(id));
			cliente.setNome(nome);
			cliente.setCPF(cpf);
			cliente.setEmail(email);

			System.out.println("ID: " + id);
			System.out.println("nome: " + nome);
			System.out.println("email: " + email);
			System.out.println("cpf: " + cpf);
			
			clienteServico.alterarCliente(cliente);

			resp.setContentType("text/html");
			
			
			
			PrintWriter out = resp.getWriter();
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
