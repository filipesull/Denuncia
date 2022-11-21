
package br.projetodenunciaweb.controller.servlet.denuncia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.entidade.Crime;

@WebServlet("/DenuncaFormServlet")
public class DenuncaFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 try {
		 
		 String idCliente = req.getParameter("id");
			
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<!DOCTYPE html>");
			printWriter.print("<html lang='pt-BR'>");
			printWriter.print("<head>");
			printWriter.print("<meta charset='UTF-8'>");
			printWriter.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
			printWriter.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
			printWriter.print("<form action='DenunciaAddServlet' method='get'>");
			
			printWriter.print("<h2>CADASTRO DE DENÚNCIA</h2>");
			printWriter.print("<p>Denúncia</p>");
			printWriter.print("<label>Local</label><br/>");
			printWriter.print("<input style='width: 300px' type='text' name='local'/><br/><br/>");
			
			printWriter.print("<label>Data e hora</label><br/>");
			printWriter.print("<input type='datetime-local' name='dataHora'/><br/><br/>");
			
			printWriter.print("<label>Tipo do crime</label><br/>");
			printWriter.print("<select style='width: 300px' name='tipoViolencia'>"
					+ "<option>Selecione...</option>"
					+ "<option>Sexual</option>"
					+ "<option>Física</option>"
					+ "<option>Patrimonial</option>"
					+ "<option>Psicológica</option></option>"
					+ "<option>Moral</option>"
					+ "<select/><br/><br/>");
			
			printWriter.print("<label>Etnia do agressor</label><br/>");
			printWriter.print("<select style='width: 300px' name='etnia'>"
					+ "<option>Selecione...</option>"
					+ "<option>Branco</option>"
					+ "<option>Negro</option>"
					+ "<option>Pardo</option>"
					+ "<select/><br/><br/>");
			
			printWriter.print("<label>Grau de proximidade</label><br/>");
			printWriter.print("<select style='width: 300px' name='proximidade'>"
					+ "<option>Selecione...</option>"
					+ "<option>Desconhecido</option>"
					+ "<option>Parente</option>"
					+ "<option>Amigo</option>"
					+ "<option>Conjuge</option>"
					+ "<select/><br/><br/>");
						
			printWriter.print("<label>Altura</label><br/>");
			printWriter.print("<select style='width: 300px' name='altura'>"
					+ "<option>Selecione...</option>"
					+ "<option>Alta</option>"
					+ "<option>Media</option>"
					+ "<option>Baixa</option>"
					+ "<select/><br/><br/>");
			printWriter.print("<input type='hidden' name='idCliente' value ='" + idCliente + "'/>");
			
			printWriter.print("<br/>");
	        printWriter.print("<input type='button' value='Voltar' onclick=\"window.location.href='/denunciaWeb'\">"); 
			printWriter.print("<input type = 'submit' value='Cadastrar'/>");
			

			printWriter.print("</form>");
	 
	} catch (Exception e) {
		
	}

 }
 }
