package br.com.livraria.service;

import java.util.List;

import br.com.livraria.model.Autor;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

public interface ServiceConsultaAutor {
	
	List<Autor> buscaPorTodosOsAutores() throws ManipulationException, NegocioException;
}
