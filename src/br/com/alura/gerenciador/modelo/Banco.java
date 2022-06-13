package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static Integer chaveSequencial =1;
	
	private static List<Usuario> listaUsuarios= new ArrayList<>();
	
    static {
        Empresa empresa = new Empresa();
        empresa.setId(chaveSequencial++);
        empresa.setNome("Alura");
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Caelum");
        Empresa empresa3 = new Empresa();
        empresa3.setId(chaveSequencial++);
        empresa3.setNome("Facebook");
        lista.add(empresa);
        lista.add(empresa2);
        lista.add(empresa3);
        
        Usuario u1 = new Usuario();
        u1.setLogin("wagner");
        u1.setSenha("1");

        Usuario u2 = new Usuario();
        u2.setLogin("wagner");
        u2.setSenha("1");
        
        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        
    }
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return lista;
	}

	public void removeEmpresa(Integer id) { 
	    Iterator<Empresa> it = lista.iterator(); 
	    
	    while(it.hasNext()) {
	    	Empresa empresa = it.next();
	    	
	    	if(empresa.getId() == id ) {
	    		it.remove();
	    	}
	    }
	}

	public Empresa buscaEmpresaPorID(Integer id) {
		
		for(Empresa empresa: lista) {
			if(empresa.getId() == id)
				return empresa;
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}

		return null;
	} 
}
