//AUTOR: Gustavo Batista Montenegro

package br.projetodenunciaweb.controller.servlet.crime;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.entidade.Crime;
import br.projetodenunciaweb.servicos.ServicoCrime;

@WebServlet("/CrimeSalvarEditarServlet")
public class CrimeSalvarEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			String descricao = req.getParameter("descricao");
			
			long id = Integer.parseInt(req.getParameter("id"));

			ServicoCrime crimeServico = new ServicoCrime();
			Crime crime = crimeServico.listarCrimePeloCodigo(id);
			crime.setDescricao(descricao);

			System.out.println("ID: " + id);
			System.out.println("descricao: " + descricao);
			
			crimeServico.alterarCrime(crime);

			resp.setContentType("text/html");
			
			
			
			PrintWriter out = resp.getWriter();
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
