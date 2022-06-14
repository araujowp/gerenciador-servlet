package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{

	public RemoveEmpresa() {
	}

	public String executar(HttpServletRequest request) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
