package br.edu.fjn.jpa.dao.interf;

import java.util.List;

import br.edu.fjn.jpa.model.produto.Produto;


public interface DaoInterfaceProduto {
	boolean salvar(Produto produto) ;
	boolean atualizar(Produto produto);
	List<Produto> listar();
<<<<<<< HEAD
	List localizar( String descricaoPro, String genero);
=======
	List localizar(String descricaoPro, String genero);
>>>>>>> origin/master
}
