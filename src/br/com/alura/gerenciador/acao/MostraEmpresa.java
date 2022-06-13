package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao{

	@Override
	public String executar(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("estamos no executa do mostra empresa");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco  = new Banco();
		Empresa empresa = banco.buscaEmpresaPorID(id);
		
		System.out.println("mostrando empresa " + empresa.getNome());
		request.setAttribute("empresa", empresa);
		
		return "forward:/formAlteraEmpresa.jsp";
	}

}
