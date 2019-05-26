package br.com.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.livraria.util.JPAUtil;

@Transacional // 3. define esta classe como gerenciada pela anotação 
@Interceptor  // 4. define que esta classe é um interceptador em alusão ao Filter da especificação Servlet
public class GerenciadorDeTransacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	
	@AroundInvoke  // 6. especifica o escopo de atuação do metodo sendo "ao redor" com begin() e commit()
	public Object executaTx(InvocationContext context) throws Exception {
		this.entityManager.getTransaction().begin();
		
		// 5. context = objeto que possui um metodo que possui a anotação @transacional - retornando qualquer objeto: string, autor, livro...
		Object resultado = context.proceed();
		
		this.entityManager.getTransaction().commit();
		
		return resultado;
	}
}














