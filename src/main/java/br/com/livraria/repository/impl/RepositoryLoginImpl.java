package br.com.livraria.repository.impl;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.livraria.model.Usuario;
import br.com.livraria.repository.RepositoryLogin;
import br.com.livraria.util.JPAUtil;

@Dependent
public class RepositoryLoginImpl implements RepositoryLogin {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;


	@Override
	public Usuario efetuaLogin(Usuario usuario) {
		TypedQuery<Usuario> consulta = this.entityManager
				.createQuery("SELECT u FROM Usuario u WHERE u.email = :pEmail AND u.senha = :pSenha", Usuario.class);
		consulta.setParameter("pEmail", usuario.getEmail());
		consulta.setParameter("pSenha", usuario.getSenha());

		Usuario resultado = consulta.getSingleResult();

		return resultado;
	}

}
