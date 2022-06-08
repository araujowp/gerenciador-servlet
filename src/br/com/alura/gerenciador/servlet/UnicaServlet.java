package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.EditaEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaServlet
 */
@WebServlet(name = "Empresa", urlPatterns = { "/empresa" })
public class UnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("acao");
		
		if(parametro.equals("listaEmpresas")) {
			ListaEmpresas lista = new ListaEmpresas(request, response);
			lista.executar();
		}else if(parametro.equals("removeEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa(request, response);
			acao.executar();
		}else if(parametro.equals("novaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa(request, response);
			acao.executar();
		}else if(parametro.equals("editaEmpresa")) {
			System.out.println("chegamos no editar");
			EditaEmpresa acao = new EditaEmpresa(request, response);
			acao.executar();
			System.out.println("adicionando");
		}else if(parametro.equals("mostraEmpresa")) {
		    MostraEmpresa acao = new MostraEmpresa(request, response);
		    acao.executa();
		}else{
			System.out.println("parametro acao invalida");
		}
	}

}
