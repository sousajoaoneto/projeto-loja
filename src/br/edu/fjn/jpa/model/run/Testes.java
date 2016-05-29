package br.edu.fjn.jpa.model.run;


import java.util.List;

import br.edu.fjn.jpa.dao.impl.DaoUsuario;
import br.edu.fjn.jpa.model.usuario.Usuario;

public class Testes {
	public static void main(String[] args) {
		
		List<Usuario> usuarios = new DaoUsuario().listar();
		
		for(int i=0;i<usuarios.size();i++){
			System.out.println(usuarios.get(i).getNome());
		}
		
	}

}
