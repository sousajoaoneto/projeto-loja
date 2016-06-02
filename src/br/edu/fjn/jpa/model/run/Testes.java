package br.edu.fjn.jpa.model.run;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import br.edu.fjn.dao.util.Util;

public class Testes {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		
		/*Produto produto = new DaoProduto().findById(2);*/
		
		System.out.println(Util.modifyDate("1996-12-27").toLocaleString());
		/*if(produto!=null){
			System.out.println(produto.toString());
		}else{
			System.out.println("Sem produto");
		}*/
		
	}

}
