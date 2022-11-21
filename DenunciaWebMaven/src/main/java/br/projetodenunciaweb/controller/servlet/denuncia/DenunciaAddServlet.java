
package br.projetodenunciaweb.controller.servlet.denuncia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.servicos.ServicoDenuncia;

@WebServlet("/DenunciaAddServlet")
public class DenunciaAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
    	
    	String idCliente = req.getParameter("idCliente");
    	String local = req.getParameter("local");
        String dataHora = req.getParameter("dataHora");
        String etnia = req.getParameter("etnia");
        String altura = req.getParameter("altura");
        String proximidade = req.getParameter("proximidade");
        String tipoViolencia = req.getParameter("tipoViolencia");
         
        System.out.println("SALVANDO...");
    	 
    	
    	try {
    		ServicoDenuncia denunciaServico =new ServicoDenuncia(); 	
       	
    		denunciaServico.cadastrar(idCliente, dataHora, local,etnia,proximidade,altura,tipoViolencia); 
			
    	} catch (Exception e) {
			e.printStackTrace();
		}

    	res.setContentType("text/html");
        
        PrintWriter printWriter = res.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Deuncia salva com sucesso</h1>");
        printWriter.print("<p> ID do cliente: " + idCliente + "</p>");
        printWriter.print("<p> Local: " + local + "</p>");
        printWriter.print("<p> Data e hora: " + dataHora + "</p>");
        printWriter.print("<p> Etnia: " + etnia + "</p>");
        printWriter.print("<p> Altura: " + altura + "</p>");
        printWriter.print("<p> Proximidade: " + proximidade + "</p>");
        printWriter.print("<p> Tipo de violência: " + tipoViolencia + "</p>");
        printWriter.print("<br/>");
        printWriter.print("<input type='button' value='Voltar' onclick=\"window.location.href='/denunciaWeb'\">"); 
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();

        
    }

}
