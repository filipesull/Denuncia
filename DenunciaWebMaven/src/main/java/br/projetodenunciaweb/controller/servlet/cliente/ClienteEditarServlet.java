
package br.projetodenunciaweb.controller.servlet.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.servicos.ServicoCliente;



@WebServlet("/ClienteEditarServlet")
public class ClienteEditarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    	try {
    		long id = Integer.parseInt(req.getParameter("id"));
            
            System.out.println("ID: " + id);
            ServicoCliente clienteServico=new ServicoCliente();
            Cliente cliente=new  Cliente();
            cliente=clienteServico.listarClientePeloCodigo(id);
            System.out.println("Nome: " + cliente.getNome());
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
	        out.println("<h1>Editar Cliente</h1>");
            out.print("<form action='ClienteSalvarEditarServlet' method='get'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+cliente.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Nome:</td><td><input type='text' name='nome' value='"+cliente.getNome()+"'/></td></tr>");  
	        out.print("<tr><td>CPF:</td><td><input type='text' name='cpf' value='"+cliente.getCPF()+"'/>  	                </td></tr>");  
	        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+cliente.getEmail()+"'/></td></tr>"); 
	        
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