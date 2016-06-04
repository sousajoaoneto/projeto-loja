package br.edu.fjn.jpa.model.run;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import br.edu.fjn.jpa.dao.impl.DaoPedido;

public class Testes {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		
		/*Produto produto = new DaoProduto().findById(2);*/
		
		new DaoPedido().listar();
		
		/*if(produto!=null){
			System.out.println(produto.toString());
		}else{
			System.out.println("Sem produto");
		}*/
		
	}

}
