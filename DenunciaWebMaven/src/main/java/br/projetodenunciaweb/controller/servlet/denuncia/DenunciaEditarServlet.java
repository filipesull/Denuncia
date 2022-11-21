
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


@WebServlet("/DenunciaEditarServlet")
public class DenunciaEditarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    	try {
    		long id = Integer.parseInt(req.getParameter("id"));
 
            System.out.println("ID: " + id);
            ServicoDenuncia denunciaServico = new ServicoDenuncia();
            Denuncia denuncia =new  Denuncia();
            denuncia = denunciaServico.listarPorCodigo(id);
            System.out.println("Denuncia do cliente: " + denuncia.getIdCliente());
            System.out.println("ID da denuncia: " + denuncia.getId());
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
	        out.println("<h1>Editar Denúncia</h1>");
            out.print("<form action='DenunciaSalvarEditarServlet' method='get'>");  
	        out.print("<table>");
	        
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+denuncia.getId()+"'/></td></tr>");
	        out.print("<tr><td></td><td><input type='hidden' name='idCliente' value='"+denuncia.getIdCliente()+"'/></td></tr>");  
	        out.print("<tr><td>Local:</td><td><input type='text' name='local' value='"+denuncia.getLocal()+"'/></td></tr>");  
	        out.print("<tr><td>Data e hora:</td><td><input type='text' name='dataHora' value='"+denuncia.getDataHora()+"'/></td></tr>");  
	        out.print("<tr><td>Tipo de crime:</td><td><input type='text' name='tipoViolencia' value='"+denuncia.getTipoViolencia()+"'/></td></tr>");
	        out.print("<tr><td>Etnia do agressor:</td><td><input type='text' name='etnia' value='"+denuncia.getEtnia()+"'/></td></tr>");
	        out.print("<tr><td>Proximidade:</td><td><input type='text' name='proximidade' value='"+denuncia.getProximidade()+"'/></td></tr>");
	        out.print("<tr><td>Altura:</td><td><input type='text' name='altura' value='"+denuncia.getAltura()+"'/></td></tr>");  
	        
	        out.print("</table>");
			out.print("<br/><br/>");
			out.print("<input type='button' value='Voltar' onclick=\"window.location.href='/denunciaWeb'\">"); 
	        
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  

			
		} catch (Exception e) {
			e.printStackTrace();
		}

        

        
    }
 } 