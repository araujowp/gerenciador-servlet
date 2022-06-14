package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executar(HttpServletRequest request) throws ServletException, IOException {

		HttpSession sessao = request.getSession();
//		sessao.removeAttribute("usuarioLogado");
		sessao.invalidate();//invalida toda a sessão inclusive cookie
		return "redirect:entrada?acao=LoginForm";
	}

}
