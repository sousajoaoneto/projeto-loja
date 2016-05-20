package br.edu.fjn.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.controllers.LoginController;

@Intercepts
public class AuthenticationInterceptor implements Interceptor {
	
	@Inject
	private Result result;
	
	@Inject
	private UserSession userSession;
	
	@Override
	public boolean accepts(ControllerMethod cm) {
		boolean temNoMetodo = cm.getMethod().isAnnotationPresent(Public.class);		
		boolean temNaClasse = cm.getController().getType().isAnnotationPresent(Public.class);
		return !( temNoMetodo || temNaClasse );
	}

	@Override
	public void intercept(InterceptorStack is, ControllerMethod cm, Object obj) throws InterceptionException {
		if(userSession.isLogged()){
			is.next(cm, obj);
		}else{			
			result.redirectTo(LoginController.class).form();			
		}
	}
	
}
