package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaServlet
 */
@WebServlet(name = "Entrada", urlPatterns = { "/entrada" })
public class UnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("acao");

		HttpSession sessao = request.getSession();
		
		boolean usuarioLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida  = !(parametro.equals("Login") || parametro.equals("LoginForm"));
		
		if(acaoProtegida && usuarioLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		
		String nome  = null;
		try {
			Class classe  = Class.forName("br.com.alura.gerenciador.acao." + parametro);
			Acao acao = (Acao)classe.newInstance();
			nome = acao.executar(request);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw(new ServletException(e));
		} 
		
		String[] tipoEEndereco = nome.split(":");
	    if(tipoEEndereco[0].equals("forward")) {
	        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
	        rd.forward(request, response);
	    } else {
	        response.sendRedirect(tipoEEndereco[1]);

	    }
	}

}
