package br.com.livraria.test;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.livraria.model.Autor;
import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.service.impl.ServiceAutorImpl;
import br.com.livraria.util.JPAUtil;

public class GravaAutoresElivros {
	public static void main(String[] args) {
		Autor autor1 = new Autor();
		Livro livro1 = new Livro();
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		autor1.setNome("katia");
		//entityManager.persist(autor1);
		entityManager.getTransaction().commit();
		
		entityManager.getTransaction().begin();
		livro1.setTitulo("a cabana");
		livro1.setPreco(35.0);
		livro1.setIsbn(112233112);
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2018, 25, 12);
		livro1.setDataLancamento(dataLancamento.getTime());
		Query consulta = entityManager.createQuery("from Autor");
		Autor autor = (Autor) consulta.getSingleResult();
		livro1.setAutor(autor);
		entityManager.persist(livro1);
		entityManager.getTransaction().commit();
		
	}
}
