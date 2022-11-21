package br.projetodenunciaweb.controller.servlet.crime;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.entidade.Crime;
import br.projetodenunciaweb.servicos.ServicoCrime;

@WebServlet("/CrimeListServlet")
public class CrimeListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			ServicoCrime crimeServico = new ServicoCrime();
			ArrayList<Crime> crimes = new ArrayList<Crime>();
			crimes = crimeServico.listarCrimes();
			out.println("<h1>Lista de Crimes</h1>");

			out.print("<table border='1' width='350px'");
			out.print(
					"<tr><th>ID</td><th>DESCRIÇÃO</th><th>Edit Crime</th></tr>");
			System.out.println("descricao: " + crimes.size());
			for (Crime e : crimes) {
				out.print("<tr><td>" + e.getId() + "</td><td>" + e.getDescricao() 
				+  "</td><td><a href='CrimeEditarServlet?id=" + e.getId()+ "'>edit crime</a></td>" 
				+ "</td></tr>");
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
