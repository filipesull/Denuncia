
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



@WebServlet("/CrimeEditarServlet")
public class CrimeEditarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    	try {
    		long id = Integer.parseInt(req.getParameter("id"));
            
            System.out.println("ID: " + id);
            ServicoCrime crimeServico=new ServicoCrime();
            Crime crime= new  Crime();
            crime=crimeServico.listarCrimePeloCodigo(id);
            System.out.println("Descricao do crime: " + crime.getDescricao());
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
	        out.println("<h1>Editar Crime</h1>");
            out.print("<form action='CrimeSalvarEditarServlet' method='get'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+crime.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Descricao:</td><td><input type='text' name='descricao' value='"+crime.getDescricao()+"'/></td></tr>");  
	        
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