

package br.projetodenunciaweb.controller.servlet.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projetodenunciaweb.excecoes.ExcecaoCliente;
import br.projetodenunciaweb.entidade.Endereco;
import br.projetodenunciaweb.servicos.ServicoCliente;


@WebServlet("/ClienteAddServlet")
public class ClienteAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String bairro = req.getParameter("bairro");
        String cidade = req.getParameter("cidade");
        String estado = req.getParameter("estado");
        String numero = req.getParameter("numero");
        
 
        System.out.println("nome: " +nome);
    	 
    	
    	try {
    		ServicoCliente clienteServico =new ServicoCliente();
    		
        	Endereco enderecoCliente= new Endereco (bairro, cidade, estado, numero);
        	
			clienteServico.cadastrarCliente(nome, cpf, email, enderecoCliente);
			
		} catch (ExcecaoCliente e) {
			e.printStackTrace();
		}

        resp.setContentType("text/html");
        
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Cliente Salvo</h1>");
        printWriter.print("<p> nome: " + nome + "</p>");
        printWriter.print("<p> email: " + email + "</p>");
        printWriter.print("<p> cpf: " + cpf + "</p>");
        printWriter.print("<p> estado: " + estado + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();

        
    }
    
    
}
