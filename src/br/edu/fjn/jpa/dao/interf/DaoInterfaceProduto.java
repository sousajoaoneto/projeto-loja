package br.edu.fjn.jpa.dao.interf;

import java.util.List;

import br.edu.fjn.jpa.model.produto.Produto;


public interface DaoInterfaceProduto {
	boolean salvar(Produto produto) ;
	void atualizar(Produto produto);
	void deletar(Produto produto);
	List<Produto> listar();
	List localizar(Integer id, String descricaoPro, String genero);
}
