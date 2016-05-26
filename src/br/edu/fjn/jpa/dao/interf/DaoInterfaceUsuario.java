package br.edu.fjn.jpa.dao.interf;

import java.util.List;

import br.edu.fjn.jpa.model.usuario.Usuario;


public interface DaoInterfaceUsuario {
	void salvar(Usuario usuario) ;
	void atualizar(Usuario usuario);
	void deletar(Usuario usuario);
	List<Usuario> listar();
}
