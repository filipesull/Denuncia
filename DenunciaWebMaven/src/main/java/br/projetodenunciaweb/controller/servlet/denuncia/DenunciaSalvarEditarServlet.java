package br.projetodenunciaweb.controller.servlet.denuncia;

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

@WebServlet("/DenunciaSalvarEditarServlet")

public class DenunciaSalvarEditarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			
			String id = req.getParameter("id");
	    	String local = req.getParameter("local");
	        String dataHora = req.getParameter("dataHora");
	        String etnia = req.getParameter("etnia");
	        String altura = req.getParameter("altura");
	        String proximidade = req.getParameter("proximidade");
	        String tipoViolencia = req.getParameter("tipoViolencia");
	        
	        System.out.println("ID: " + id);
			System.out.println("local: " + local);
			System.out.println("dataHora: " + dataHora);
			System.out.println("Crime: " + tipoViolencia);
			System.out.println("Etnia: " + etnia);
			System.out.println("Proximidade: " + proximidade);
			System.out.println("Altura: " + altura);
	        
	        

			ServicoDenuncia denunciaServico=new ServicoDenuncia();
            Denuncia denuncia = denunciaServico.listarPorCodigo(Integer.parseInt(id));
            denuncia.setLocal(local);
            denuncia.setDataHora(dataHora);
            denuncia.setTipoViolencia(tipoViolencia);
            denuncia.setEtnia(etnia);
            denuncia.setProximidade(proximidade);
            denuncia.setAltura(altura);

			System.out.println("ID: " + id);
			System.out.println("local: " + local);
			System.out.println("dataHora: " + dataHora);
			System.out.println("Crime: " + tipoViolencia);
			System.out.println("Etnia: " + etnia);
			System.out.println("Proximidade: " + proximidade);
			System.out.println("Altura: " + altura);
			
			
			denunciaServico.alterar(denuncia);

			resp.setContentType("text/html");
			
			
			
			PrintWriter out = resp.getWriter();
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
