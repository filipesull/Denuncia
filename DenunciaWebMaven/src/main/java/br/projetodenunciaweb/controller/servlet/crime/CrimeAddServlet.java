

package br.projetodenunciaweb.controller.servlet.crime;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.servicos.ServicoCrime;

@WebServlet("/CrimeAddServlet")
public class CrimeAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    	String descricao = req.getParameter("descricao");
       
 
        System.out.println("descricao: " +descricao);
    	
    	try {
    		ServicoCrime servicoCrime = new ServicoCrime();
    		servicoCrime.cadastrarCrime(descricao);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

        resp.setContentType("text/html");
        
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Crime Salvo</h1>");
        printWriter.print("<p> Descrição: " + descricao + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();

        
    }
    
    
}
