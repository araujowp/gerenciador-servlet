package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.EditaEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
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
		
		String nome  = null;
		try {
			Class classe  = Class.forName("br.com.alura.gerenciador.acao." + parametro);
			Acao acao = (Acao)classe.newInstance();
			nome = acao.executar(request);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw(new ServletException(e));
		} 
		
//		if(parametro.equals("listaEmpresas")) {s
//			ListaEmpresas lista = new ListaEmpresas();
//			nome = lista.executar(request);
//		}else if(parametro.equals("removeEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executar(request);
//		}else if(parametro.equals("novaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executar(request);
//		}else if(parametro.equals("editaEmpresa")) {
//			EditaEmpresa acao = new EditaEmpresa();
//			nome = acao.executar(request);
//		}else if(parametro.equals("mostraEmpresa")) {
//		    MostraEmpresa acao = new MostraEmpresa();
//		    nome = acao.executar(request);
//		}else if(parametro.equals("novaEmpresaForm")){
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executar(request);
//		}else {
//			System.out.println("parametro acao invalida");
//		}
		
		String[] tipoEEndereco = nome.split(":");
	    if(tipoEEndereco[0].equals("forward")) {
	        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
	        rd.forward(request, response);
	    } else {
	        response.sendRedirect(tipoEEndereco[1]);

	    }
	}

}
