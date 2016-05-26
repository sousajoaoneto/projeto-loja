package br.edu.fjn.components;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.fjn.model.Usuario;

@SessionScoped
@Named("userSession")
public class UserSession implements Serializable{
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogged(){
		return usuario != null;
	}
	
	public void loggout(){
		usuario = null;
	}
}
