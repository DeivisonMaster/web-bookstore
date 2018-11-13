package br.com.livraria.service.impl;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.livraria.model.Usuario;
import br.com.livraria.repository.RepositoryLogin;
import br.com.livraria.service.ServiceLogin;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

@Dependent
public class ServiceLoginImpl implements ServiceLogin {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RepositoryLogin repositoryLogin;

	@Override
	public Usuario efetuaLogin(Usuario usuario) throws ManipulationException {
		Usuario usuarioPesquisado = null;
		try {
			usuarioPesquisado = this.repositoryLogin.efetuaLogin(usuario);
			if(usuarioPesquisado != null) {
				return usuarioPesquisado;
			}
		} catch (Exception e) {
			throw new ManipulationException("Erro ao consultar por usuario no sistema", e);
		}
		return usuarioPesquisado;
	}

}
