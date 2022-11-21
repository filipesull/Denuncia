
package br.projetodenunciaweb.controller.servlet.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.entidade.Denuncia;
import br.projetodenunciaweb.servicos.ServicoCliente;
import br.projetodenunciaweb.servicos.ServicoDenuncia;

@WebServlet("/ClienteListServlet")
public class ClienteListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			ServicoCliente clienteServico = new ServicoCliente();
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			clientes = clienteServico.listarClientes();
			out.println("<h1>Lista de Clientes</h1>");

			out.print("<table border='1' width='100%'");
			out.print(
					"<tr><th>Id</th><th>NOME</th><th>CPF</th><th>Email</th><th>Edit Cliente</th><th>DENUNCIA</th></tr>");
			System.out.println("Clientes cadastrados: " + clientes.size());
			for (Cliente e : clientes) {
				out.print("<tr><td>" + e.getId() + "</td><td>" + e.getNome() + "</td><td>" + e.getCPF() + "</td> <td>"+ e.getEmail() 
				+ "</td><td><a href='ClienteEditarServlet?id=" + e.getId()+ "'>edit</a></td>"
				+ "<td><a href='DenuncaFormServlet?id=" + e.getId()+ "'>ADD</a></td></tr>");
			}
			out.print("</table>");
			out.print("<br/><br/>");
			out.print("<input type='button' value='Voltar' onclick=\"window.location.href='/denunciaWeb'\">"); 
			

			out.close();
		} catch (Exception e) {
			System.out.println("ERRO NA CONVERSAO: CONVERSAO INDISPONIVEL!:" + e.getMessage());
		} finally {
			System.out.println("OPERATION ENDED");
		}
	}

}
