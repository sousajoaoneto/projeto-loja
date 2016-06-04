package br.edu.fjn.jpa.model.run;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.impl.DaoProduto;
import br.edu.fjn.jpa.model.produto.Genero;
import br.edu.fjn.jpa.model.produto.Modelo;
import br.edu.fjn.jpa.model.produto.Produto;
import br.edu.fjn.jpa.model.produto.Tecnologia;


public class Testes {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		EntityManager entityManager = FabricaDeConexao.getManager();
		
		Modelo modelo = new Modelo();
		modelo.setDescricao("Mão");
		
		Produto produto = new Produto();
		produto.setDescricao("Calango da Hora");
		produto.setEstoque(2);
		produto.setGenero(Genero.MASCULINO);
		produto.setModelo(modelo);
		produto.setTecnologia(Tecnologia.ANALOGICO);
		produto.setPreco(900.00);
		
		new DaoProduto().atualizar(produto);

		
	}

}
