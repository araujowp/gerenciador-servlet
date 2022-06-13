package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Acao {

	String executar(HttpServletRequest request) throws ServletException, IOException;
}
