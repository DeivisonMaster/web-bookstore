package br.com.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.livraria.util.JPAUtil;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	public GerenciadorDeTransacao() {
		this.entityManager = JPAUtil.getEntityManager();
	}
	
	@AroundInvoke
	public Object executaTx(InvocationContext context) throws Exception {
		this.entityManager.getTransaction().begin();
		
		// invoca o metodo que possui @transacional - retornando qualquer objeto: string, autor, livro...
		Object resultado = context.proceed();
		
		this.entityManager.getTransaction().commit();
		
		return resultado;
	}
}














