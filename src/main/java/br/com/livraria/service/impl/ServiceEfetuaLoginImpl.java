package br.com.livraria.service.impl;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.livraria.model.Usuario;
import br.com.livraria.repository.RepositoryLogin;
import br.com.livraria.service.ServiceEfetuaLogin;
import br.com.livraria.service.ServiceLogin;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

@Dependent
public class ServiceEfetuaLoginImpl implements ServiceEfetuaLogin {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServiceLogin serviceLogin;

	@Override
	public boolean efetuaLogin(Usuario usuario) throws NegocioException, ManipulationException {
		Usuario usuarioConsulta = this.serviceLogin.efetuaLogin(usuario);

		if (usuarioConsulta != null) {
			return true;
		}
		throw new NegocioException("Usuario não cadastrado no sistema");
	}

}
