package br.edu.fjn.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.components.CarrinhoItem;
import br.edu.fjn.components.CarrinhoSession;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.jpa.dao.impl.DaoPedido;
import br.edu.fjn.jpa.model.pedido.Entrega;
import br.edu.fjn.jpa.model.pedido.FormaPagamento;
import br.edu.fjn.jpa.model.pedido.ItemPedido;
import br.edu.fjn.jpa.model.pedido.Pagamento;
import br.edu.fjn.jpa.model.pedido.Pedido;

@Controller
public class PedidoController {
	
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	@Inject
	private CarrinhoSession carrinhoSession;
	@Inject
	private DaoPedido dao;
	
	@Get("pedidos")
	public void list(){
		result.include("pageTitle", "Meus Pedidos");
		result.include("pedidos", dao.listar());
	}
	
	@Get("pedidos/finalizar")
	public void save() throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException{
		StringBuffer msg = new StringBuffer();
		if(carrinhoSession.getTotalDeItens() > 0){
			List<ItemPedido> itemPedido = new ArrayList<>();
			
			Pagamento pagamento = new Pagamento();
			pagamento.setForma_pagamento(FormaPagamento.BOLETO);
			pagamento.setParcelamento(1);
			pagamento.setStatus_pagamento(false);
			
			Entrega entrega = new Entrega("Não Enviado");
			
			for( CarrinhoItem carrinhoItem : carrinhoSession.getItens() ){
				itemPedido.add( new ItemPedido( carrinhoItem.getQuantidade(), carrinhoItem.getProduto() ) );
			}					
			
			Pedido pedido = new Pedido( carrinhoSession.getTotal(), userSession.getUsuario(), itemPedido, pagamento, entrega);
			
			if( dao.salvar(pedido) ){
				msg.append("Produto inserido");
				carrinhoSession.clear();
			}else{
				msg.append("Falha ao finalizar pedido");
			}	
			
			
		}else{
			msg.append("Sem produtos no carrinho");
		}
		result.include("msg",msg);
		result.redirectTo(this).list();
	}

}
