package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class EditaEmpresa implements Acao {

	public EditaEmpresa() {
	}

	public String executar(HttpServletRequest request) throws IOException, ServletException {
        System.out.println("cheguei no executar do edita empresa");

        String nomeEmpresa = request.getParameter("nome");
        String paramDataEmpresa = request.getParameter("data");
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        System.out.println(id);
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPorID(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
//        response.sendRedirect("redirect:empresa?acao=listaEmpresas");
		return "redirect:empresa?acao=ListaEmpresas";		
	}

}
