package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class NovaEmpresaForm implements Acao{

	@Override
	public String executar(HttpServletRequest request) throws ServletException, IOException {
		return "forward:formNovaEmpresa.jsp";
	}

}
