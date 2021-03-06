package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada") estamos pegando do webxml
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servLetResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AutorizacaoFilter");
		
		HttpServletRequest request  = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servLetResponse;
		
		String parametroAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		
		boolean usuarioLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida  = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));
		
		if(acaoProtegida && usuarioLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
