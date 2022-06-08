package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public MostraEmpresa(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void executa() throws ServletException, IOException {
		System.out.println("estamos no executa do mostra empresa");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco  = new Banco();
		Empresa empresa = banco.buscaEmpresaPorID(id);
		
		System.out.println("mostrando empresa " + empresa.getNome());
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		dispatcher.forward(request, response);
	}

	
}
