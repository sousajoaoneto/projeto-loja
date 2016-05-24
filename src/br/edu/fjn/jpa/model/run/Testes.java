package br.edu.fjn.jpa.model.run;


import java.util.Date;
import javax.persistence.EntityManager;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.impl.DaoUsuario;
import br.edu.fjn.jpa.model.endereco.Cidade;
import br.edu.fjn.jpa.model.endereco.Endereco;
import br.edu.fjn.jpa.model.endereco.Estado;
import br.edu.fjn.jpa.model.usuario.Tipo;
import br.edu.fjn.jpa.model.usuario.Usuario;

public class Testes {
	public static void main(String[] args) {
		EntityManager entityManager = FabricaDeConexao.getManager();
		
		Estado estado = new Estado();
		estado.setNome("Ceara");
		
		Cidade cidade = new Cidade();
		cidade.setNome("Juazeiro");
		cidade.setEstado(estado);
		cidade.setCep("565235");
		
		
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setNumero(10);
		endereco.setRua("Ramiro");
		
	
		Usuario usuario = new Usuario();
		usuario.setCpf("985632");
		usuario.setNome("Josineide");
		usuario.setEndereco(endereco);
		usuario.setTipo(Tipo.GERENTE);
		usuario.setUsername("josi");
		usuario.setData_nasc(new Date(10,05,90));
		usuario.setSenha("123");
		usuario.setEmail("josi@gmail.com");
		
		/*
		Modelo modelo = new Modelo();
		modelo.setDescricao("esporte");
		
		Produto produto = new Produto();
		produto.setDescricao("Relogio bebeto");
		produto.setEstoque(2);
		produto.setGenero(Genero.FEMININO);
		produto.setModelo(modelo);
		produto.setTecnologia(Tecnologia.ANALOGICO);
		produto.setPreco(30.00);
		
		
		ItemPedido itempedido = new ItemPedido();
		itempedido.setProduto(produto);
		itempedido.setQuantidade(1);
		
		
		List<ItemPedido> itemPedidos = new ArrayList<>();
		
		itemPedidos.add(itempedido);		
		
		Pedido pedido = new Pedido();
		pedido.setItemPedido(itemPedidos);
		//pedido.setUsuario(usuario);
		pedido.setValor_total(50.00);
		*/
		
	//	entityManager.getTransaction().begin();
		//entityManager.persist(endereco);
		new DaoUsuario().atualizar(usuario);
		//new DaoPedido().salvar(pedido);
		//entityManager.getTransaction().commit();
		//entityManager.close();
		
	}

}
