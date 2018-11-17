package br.com.livraria.service;

import java.io.Serializable;
import java.util.List;

import br.com.livraria.model.Livro;

public interface ServiceConsultaLivro extends Serializable{

	List<Livro> buscaPorTodosOsLivros();

}
