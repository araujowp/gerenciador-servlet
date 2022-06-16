package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/entrada") vamos usar no webxml para ordenar 
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		long antes  = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		String acao = request.getParameter("acao");
		
		long depois  = System.currentTimeMillis();
		System.out.println("Tempo decorrido ação " + acao + " " + (depois - antes) );
	}

}