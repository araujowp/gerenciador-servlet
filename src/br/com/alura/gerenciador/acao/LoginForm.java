package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class LoginForm implements Acao {

    @Override
    public String executar(HttpServletRequest request)
            throws ServletException, IOException {
    	
        return "forward:formLogin.jsp";
    }
}
