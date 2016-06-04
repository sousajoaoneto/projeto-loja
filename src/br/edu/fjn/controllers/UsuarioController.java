package br.edu.fjn.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.dao.util.Util;
import br.edu.fjn.jpa.dao.impl.DaoUsuario;
import br.edu.fjn.jpa.model.endereco.Cidade;
import br.edu.fjn.jpa.model.endereco.Endereco;
import br.edu.fjn.jpa.model.endereco.Estado;
import br.edu.fjn.jpa.model.usuario.Tipo;
import br.edu.fjn.jpa.model.usuario.Usuario;

@Controller
@Path("usuario")
public class UsuarioController {

	@Inject
	private Result result;

	@Inject
	private UserSession userSession;
	@Inject
	private DaoUsuario dao;

	@Public
	@Get("cadastrar") // maybe this line can be removed
	public void form() {
		// chama usuario/form.jsp
	}

	@Public
	@Post("salvar")
	public void save(Usuario usuario, Endereco endereco, Cidade cidade, Estado estado)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		if (dao.alreadyExists("username", usuario.getUsername()) || dao.alreadyExists("cpf", usuario.getCpf())) {

			System.out.println("Existe");
			result.include("msg", "Tente outros dados");
			result.redirectTo(UsuarioController.class).form();
			return;
		}

		if (dao.count() > 0) {
			usuario.setTipo(Tipo.CLIENTE);
		} else {
			usuario.setTipo(Tipo.GERENTE);
		}

		cidade.setEstado(estado);
		endereco.setCidade(cidade);

		usuario.setData_nasc(Util.modifyDate(usuario.getData_nasc().toLocaleString()));
		usuario.setEndereco(endereco);

		dao.salvar(usuario);
		result.redirectTo(LoginController.class).form();

		System.out.println(usuario.toString());
	}

	@Get("perfil")
	public void perfil() {

	}

}
