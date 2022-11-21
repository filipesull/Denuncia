
package br.projetodenunciaweb.controller.servlet.denuncia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.entidade.Denuncia;
import br.projetodenunciaweb.servicos.ServicoDenuncia;

@WebServlet("/DenunciaListServlet")
public class DenunciaListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			ServicoDenuncia denunciaServico = new ServicoDenuncia();
			ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();
			denuncias = denunciaServico.listarTodas();
			out.println("<h1>Lista de Denuncias</h1>");

			out.print("<table border='1' width='350px'");
			out.print(
					"<tr><th>idCliente</td><th>idDenuncia</td><th>LOCAL</td><th>Data e hora</td><th>CRIME COMETIDO</td><th>ETNIA DO AGRESSOR</td><th>PROXIMIDADE DO AGRESSOR COM A VITIMA</td><th>ALTURA DO AGRESSOR</td><th>Edit Denuncia</th></tr>");
			System.out.println("Quantidade de denuncias: " + denuncias.size());
			for (Denuncia e : denuncias) {
				out.print("<tr><td>" + e.getIdCliente() + "</td><td>" + e.getId() + "</td><td>" + e.getLocal() + "</td><td>" + e.getDataHora() + "</td><td>" + e.getTipoViolencia() + "</td><td>" + e.getEtnia() + "</td><td>" + e.getProximidade() + "</td><td>" + e.getAltura()  
				+  "</td><td><a href='DenunciaEditarServlet?id=" + e.getId()+ "'>editar denuncia</a></td>" 
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
